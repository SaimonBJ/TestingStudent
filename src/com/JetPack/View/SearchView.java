package com.JetPack.View;

import com.JetPack.DataBase;
import com.JetPack.Model.Student;
import com.JetPack.Model.Teacher;
import com.JetPack.Model.Tests;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SearchView {




    public static void searchNameStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name student for searching");
        String studentName = scanner.nextLine();
        //Output the search results to the console
        List<Student> students = DataBase.getStudents().stream().filter(student1 -> student1.getName().contains(studentName)).collect(Collectors.toList());

        System.out.println(students);
    }

    public static void searchNameTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name teacher for searching");
        String teacherName = scanner.nextLine();
        //Output the search results to the console
        List<Teacher> teachers = DataBase.getTeachers().stream().filter(teacher -> teacher.getName().contains(teacherName)).collect(Collectors.toList());

        System.out.println(teachers);
    }

    public static void searchNameTest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name test for searching");
        String testName = scanner.nextLine();
        //Output the search results to the console
        List<Tests> tests = DataBase.getTests().stream().filter(test -> test.getTestName().contains(testName)).collect(Collectors.toList());

        System.out.println(tests);
    }



}







