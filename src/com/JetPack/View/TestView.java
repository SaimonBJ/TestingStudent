package com.JetPack.View;

import com.JetPack.Controller.TestCont;
import com.JetPack.DataBase;
import com.JetPack.Exception.correctAnswerException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestView {

    public static void testStart()throws InputMismatchException{

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name again: ");
        String personName = scan.nextLine();
        Scanner answerQuestion = new Scanner(System.in);
//        int answer = answerQuestion.nextInt();
        int[] rightAnswersCounter = new int[1];
        DataBase.getQuestions().forEach(question -> {
            System.out.println("Choose one of the three answers, enter 1, 2, or 3 in the console!");
            System.out.println(question);
            String answerStr = answerQuestion.nextLine();

            try {
                try {
                    int answer = Integer.parseInt(answerStr);
                    if (answer < 1 || answer > 3) {
                        throw new correctAnswerException("Incorrect input, choose an answer from 1 to 3");
                    }
                    if (answer == question.getRightAnswerNumber()) {
                        rightAnswersCounter[0]++;
                    }
                }catch (NumberFormatException numberFormatException){
                    throw new correctAnswerException("Enter the number!");

                }
            }catch (correctAnswerException exception){
                System.out.println(exception.getMessage());
            }
       });

        System.out.println(personName + " " + "true answers: " + rightAnswersCounter[0]);

        if (rightAnswersCounter[0] < 11){

            System.out.println("The test failed!Your grade F");
        }

        else if (rightAnswersCounter[0] < 16){
            System.out.println("It's better!Your grade С");
        }

        else if (rightAnswersCounter[0] < 20){
            System.out.println("Very good!Your grade B");
        }

        else if (rightAnswersCounter[0] == 21){
            System.out.println("Perfect!Your grade A");
        }

        for (int i = 0; i < DataBase.getResults().size(); i++) {
            if (personName.equals(DataBase.getStudents().get(i).getName())){
                DataBase.getResults().get(i).getResultMap().put(DataBase.getStudents().get(i).getName(), rightAnswersCounter[0]);
            }
        }
        TestCont.testComplete();
    }
}
