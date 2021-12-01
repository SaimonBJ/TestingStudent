package com.jetpack.menu;

import com.jetpack.view.TeacherView;
import com.jetpack.view.UsersView;
import java.util.Scanner;

/**
 * Main menu of the teacher class
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class TeacherMenu {

    /**
     * Method of operation in the main teacher menu
     */
    public static void contTeacher(){
        //Teacher main menu
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Choose another teacher - enter Restart\nGo to the main menu? - enter Menu\nIf you want to close the program - press Enter");
        String tch2 = scan2.nextLine();
        if (tch2.equals("Restart")){
            TeacherView.getTeacherData();
        }

        else if (tch2.equals("Menu")){
            UsersView.viewDataBase();
        }

        else {
            System.out.println("Bye!");
        }

    }
}
