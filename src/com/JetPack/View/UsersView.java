package com.JetPack.View;

import java.util.Scanner;

public class UsersView {


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
