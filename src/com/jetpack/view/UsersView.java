package com.jetpack.view;

import com.jetpack.exception.IncorrectUserNameException;

import java.util.Scanner;

/**
 * User selection
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class UsersView {

    /**
     * Method user selection menu
     */
    public static void viewDataBase(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your position in the training center: Student, Teacher or Admin");
        String positionInCenter = scan.nextLine();
        //Training center user selection
        switch (positionInCenter) {
            case ("Student"):
                StudentView.getStudentData();
                break;

            case ("Teacher"):
                TeacherView.getTeacherData();
                break;

            case ("Admin"):
                AdminView.getAdminData();
                break;

            default:
                System.out.println("Error: there is no user data in the database!");
                viewDataBase();

        }
    }








    



}
