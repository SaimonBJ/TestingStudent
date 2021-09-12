package com.JetPack.View;
import com.JetPack.Controller.AdminCont;
import com.JetPack.DataBase;
import com.JetPack.Model.Admin;
import java.util.Scanner;
import static com.JetPack.View.PagingView.viewPagingListStudent;
import static com.JetPack.View.PagingView.viewPagingListTeacher;
import static com.JetPack.View.SearchView.searchNameStudent;
import static com.JetPack.View.SearchView.searchNameTeacher;


public class AdminView {

    public static void getAdminData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("View full list of users enter - All\nView user list page by page enter - Page\nFind a user by name enter - Search");
        String input = scanner.nextLine();

        if (input.equals("All")){
            for (Admin administrator : DataBase.getAdmins()){
                System.out.println("There are such users in the system ");

                for (int i = 0; i < administrator.getStudents().size(); i++) {

                    System.out.println( i + 1 + ".Student " +  administrator.getStudents().get(i).getName());
                }
                for (int i = 0; i < administrator.getTeachers().size(); i++) {

                    System.out.println( i + 1 + ".Teacher " +  administrator.getTeachers().get(i).getName());
                }
            }
        }

        else if (input.equals("Page")){
            System.out.println("View the student list enter - Student\nView the teacher list enter - teacher");
            String selectList = scanner.nextLine();
            if (selectList.equals("Student")){
                viewPagingListStudent();
            }
            else if (selectList.equals("Teacher")){
                viewPagingListTeacher();
            }
            else {
                System.out.println("Not found!");
                getAdminData();
            }
        }

        else if (input.equals("Search")){
            System.out.println("Find a student enter - Student\nFind a teacher enter - teacher");
            String searchPerson = scanner.nextLine();
            if (searchPerson.equals("Student")){
                searchNameStudent();
            }
            else if (searchPerson.equals("Teacher")){
                searchNameTeacher();
            }
            else {
                System.out.println("Not found!");
                getAdminData();
            }
        }
        else {
            System.out.println("Not found!");
            getAdminData();
        }
        AdminCont.contAdmin();
    }
}
