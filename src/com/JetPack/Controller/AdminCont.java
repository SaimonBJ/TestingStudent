package com.JetPack.Controller;

import com.JetPack.View.UsersView;

import java.util.Scanner;

public class AdminCont {

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
