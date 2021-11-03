package com.jetpack.controller;

import com.jetpack.view.TestView;
import com.jetpack.view.UsersView;
import java.util.Scanner;

/**
 * Choosing a job before and after you take the test
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class TestCont {

    /**
     * The method that starts the test
     */
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

    /**
     * Method for determining further work after testing
     */
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
