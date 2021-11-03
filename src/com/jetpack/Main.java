package com.jetpack;

import com.jetpack.view.UsersView;
import java.sql.SQLException;
import java.util.Scanner;
import static com.jetpack.csv.AdminCSV.readFileAdmin;
import static com.jetpack.csv.GroupCSV.readFileGroup;
import static com.jetpack.csv.QuestionCSV.readFileQuestion;
import static com.jetpack.csv.ResultCSV.readFileResult;
import static com.jetpack.csv.StudentCSV.readFileStudent;
import static com.jetpack.csv.TeacherCSV.readFileTeacher;
import static com.jetpack.csv.TestCSV.readFileTest;
import static com.jetpack.jdbcservice.AdminService.getAllAdmin;
import static com.jetpack.jdbcservice.GroupService.getAllGroups;
import static com.jetpack.jdbcservice.QuestionService.getAllQuestions;
import static com.jetpack.jdbcservice.ResultService.getAllResults;
import static com.jetpack.jdbcservice.StudentService.getAllStudents;
import static com.jetpack.jdbcservice.TeacherService.getAllTeachers;
import static com.jetpack.jdbcservice.TestsService.getAllTests;

/**
 * The main class that runs the program
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class Main {

    /**
     * Method starts the program, selects the data storage
     * @param args - command line argument
     * @throws SQLException - error when the database connection fails
     * */
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the training center!\nDo you want to work with files or a database?\nIf you choose files enter - 1\nIf you select database, enter - 2");
        String ChoiceOfStorage = scanner.nextLine();

        switch (ChoiceOfStorage){
            case ("1"):
                readFileTest();
                readFileGroup();
                readFileAdmin();
                readFileResult();
                readFileTeacher();
                readFileStudent();
                readFileQuestion();
                UsersView.viewDataBase();
                break;

            case ("2"):
                getAllAdmin();
                getAllGroups();
                getAllQuestions();
                getAllResults();
                getAllStudents();
                getAllTeachers();
                getAllTests();
                UsersView.viewDataBase();
                break;

            default:
                System.out.println("Error input!");
                break;
        }



    }
}







