package com.jetpack.view;

import com.jetpack.menu.TestMenu;
import com.jetpack.Collections;
import com.jetpack.exception.correctAnswerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.jetpack.jdbc.JDBCConnection.connectDB;

/**
 * A class for solving tests
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class TestView {

    /**
     * Method with the output of questions, answer choices and saving the results
     * @throws InputMismatchException - incorrect data entry
     * @throws correctAnswerException - the user entered a number more than 3 or a letter
     */
    public static void testStart()throws InputMismatchException{

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name again: ");
        String personName = scan.nextLine();
        Scanner answerQuestion = new Scanner(System.in);
        int[] rightAnswersCounter = new int[1];
        //Running the test solution
        Collections.getQuestions().forEach(question -> {
            System.out.println("Choose one of the three answers, enter 1, 2, or 3 in the console!");
            System.out.println(question);
            String answerStr = answerQuestion.nextLine();

            try {
                try {
                    int answer = Integer.parseInt(answerStr);
                    //The condition of correct entry of answers
                    if (answer < 1 || answer > 3) {
                        throw new correctAnswerException("Incorrect input, choose an answer from 1 to 3");
                    }
                    //Counting correct answers
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
        //Output of the student's correct answers
        System.out.println(personName + " " + "true answers: " + rightAnswersCounter[0]);

        //Grading tests result
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

        //Saving test results
        for (int i = 0; i < Collections.getResults().size(); i++) {
            if (personName.equals(Collections.getStudents().get(i).getName())){
                //Writing test results to HashMap
                Collections.getResults().get(i).getResultMap().put(Collections.getStudents().get(i).getName(), rightAnswersCounter[0]);
                //Writing test results to Data Base
                PreparedStatement preparedStatement = null;

                String sql = "UPDATE result_map SET value = ? WHERE id_student = ?";

                try {
                    Connection connection = connectDB();
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, rightAnswersCounter[0]);
                    preparedStatement.setInt(2, Collections.getStudents().get(i).getId());

                    preparedStatement.executeUpdate();

                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //Going to test main menu
        TestMenu.testComplete();
    }
}
