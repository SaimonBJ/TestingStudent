package com.JetPack;


import com.JetPack.View.UsersView;
import java.sql.SQLException;
import java.util.Scanner;

import static com.JetPack.CSV.AdminCSV.readFileAdmin;
import static com.JetPack.CSV.GroupCSV.readFileGroup;
import static com.JetPack.CSV.QuestionCSV.readFileQuestion;
import static com.JetPack.CSV.ResultCSV.readFileResult;
import static com.JetPack.CSV.StudentCSV.readFileStudent;
import static com.JetPack.CSV.TeacherCSV.readFileTeacher;
import static com.JetPack.CSV.TestCSV.readFileTest;
import static com.JetPack.JDBCService.AdminService.getAllAdmin;
import static com.JetPack.JDBCService.GroupService.getAllGroups;
import static com.JetPack.JDBCService.QuestionService.getAllQuestions;
import static com.JetPack.JDBCService.ResultService.getAllResults;
import static com.JetPack.JDBCService.StudentService.getAllStudents;
import static com.JetPack.JDBCService.TeacherService.getAllTeachers;
import static com.JetPack.JDBCService.TestsService.getAllTests;

public class Main {

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







