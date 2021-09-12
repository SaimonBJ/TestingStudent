package com.JetPack.Controller;

import com.JetPack.View.TeacherView;
import com.JetPack.View.UsersView;
import java.util.Scanner;

public class TeacherCont {

    public static void contTeacher(){

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
