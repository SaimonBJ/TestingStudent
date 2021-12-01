package com.jetpack.view;
import com.jetpack.menu.AdminMenu;
import com.jetpack.Collections;
import com.jetpack.model.Admin;
import java.util.Scanner;

import static com.jetpack.csv.AdminCSV.*;
import static com.jetpack.view.PagingView.viewPagingListStudent;
import static com.jetpack.view.PagingView.viewPagingListTeacher;
import static com.jetpack.view.SearchView.searchNameStudent;
import static com.jetpack.view.SearchView.searchNameTeacher;

/**
 * Class admin view - outputs all data available to the administrator in three ways,
 * delete all files, serialization and deserialization
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class AdminView {
    /**
     * Method of processing and output of admin data
     */
    public static void getAdminData(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("View full list of users enter - All\nView user list page by page enter - Page\nFind a user by name enter - Search\nGo to the file menu enter - Files");
        String input = scanner.nextLine();

        switch (input) {
            //View all data admin: list teachers and students.
            case "All":
                for (Admin administrator : Collections.getAdmins()) {
                    System.out.println("There are such users in the system ");

                    for (int i = 0; i < administrator.getStudents().size(); i++) {

                        System.out.println(i + 1 + ".Student " + administrator.getStudents().get(i).getName());
                    }
                    for (int i = 0; i < administrator.getTeachers().size(); i++) {

                        System.out.println(i + 1 + ".Teacher " + administrator.getTeachers().get(i).getName());
                    }
                }
                break;
            //Paging data admin: list teachers and students.
            case "Page":
                System.out.println("View the student list enter - Student\nView the teacher list enter - teacher");
                String selectList = scanner.nextLine();
                if (selectList.equals("Student")) {
                    viewPagingListStudent();
                } else if (selectList.equals("Teacher")) {
                    viewPagingListTeacher();
                } else {
                    System.out.println("Not found!");
                    getAdminData();
                }
                break;
            //Search data admin: list teachers and students.
            case "Search":
                System.out.println("Find a student enter - Student\nFind a teacher enter - teacher");
                String searchPerson = scanner.nextLine();
                if (searchPerson.equals("Student")) {
                    searchNameStudent();
                } else if (searchPerson.equals("Teacher")) {
                    searchNameTeacher();
                } else {
                    System.out.println("Not found!");
                    getAdminData();
                }
                break;
            //File menu: delete all files, serialization and deserialization.
            case "Files":
                System.out.println("Delete all files enter - Delete\nSave all data in one file enter - Save\nRestore all data to files enter - Restore");
                String fileMenu = scanner.nextLine();
                switch (fileMenu) {
                    case "Delete":
                        System.out.println("Without a data backup, everything is permanently deleted!\nDelete anyway enter - Delete\nSave data enter - Save");
                        String warning = scanner.nextLine();
                        if (warning.equals("Delete")) {
                            deleteFiles();
                        } else if (warning.equals("Save")) {
                            serializationAll();
                        }
                        break;
                    case "Save":
                        serializationAll();
                        break;
                    case "Restore":
                        deSerializationAll();
                        break;
                }
                break;
            default:
                System.out.println("Not found!");
                getAdminData();
                break;
        }
        //Going to admin main menu
        AdminMenu.contAdmin();
    }
}
