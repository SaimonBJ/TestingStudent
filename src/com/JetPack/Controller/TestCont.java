package com.JetPack.Controller;

import com.JetPack.View.TestView;
import com.JetPack.View.UsersView;
import java.util.Scanner;

import static com.JetPack.CSV.QuestionCSV.readFileQuestion;

public class TestCont {


    public static void getStartTestQuestions() {
        //The student's choice to solve the test
        Scanner scanner = new Scanner(System.in);
        System.out.println("Students are required to take a test: two subjects - Mathematics and Chemistry\nYes or No");
        String testQ = scanner.nextLine();
        if (testQ.equals("Yes")) {
            TestView.testStart();
        }

        else {
            System.out.println("You are not accepted into the training center.");
            UsersView.viewDataBase();
        }
    }

    public static void testComplete(){
        //Student's choice after completing the test
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Take the test again? - enter Restart\nGo to the main menu? - enter Menu\nIf you want to close the program - press Enter");
        String st2 = scan2.nextLine();

        try {
            if (st2.equals("Restart")){
                TestView.testStart();
            }

            else if (st2.equals("Menu")){
                UsersView.viewDataBase();
            }
            else {
                System.out.println("Bye!");
            }
        } catch (Exception e) {
            System.out.println("");
            e.printStackTrace();
        }
    }
}
