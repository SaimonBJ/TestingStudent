package com.jetpack.controller;

import com.jetpack.view.UsersView;

import java.util.Scanner;

/**
 * Main menu of the admin class
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class AdminCont {

    /**
     * Method of operation in the main administrator menu
     */
    public static void contAdmin(){
        //Admin main menu
        Scanner scan = new Scanner(System.in);
        System.out.println("If you want to exit to the main menu - enter Menu\nIf you want to close the program - press Enter");
        String adm = scan.nextLine();
        if (adm.equals("Menu")){
            UsersView.viewDataBase();
        }


        else {
            System.out.println("Bye!");

        }
    }
}
