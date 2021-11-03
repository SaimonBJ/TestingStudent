package com.jetpack.view;

import com.jetpack.Collections;
import com.jetpack.model.Student;
import com.jetpack.model.Teacher;
import com.jetpack.model.Tests;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Search information output
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class SearchView {

    /**
     * Search student method
     */
    public static void searchNameStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name student for searching");
        String studentName = scanner.nextLine();
        //Output the search results to the console
        List<Student> students = Collections.getStudents().stream().filter(student1 -> student1.getName().contains(studentName)).collect(Collectors.toList());

        System.out.println(students);
    }

    /**
     * Search teacher method
     */
    public static void searchNameTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name teacher for searching");
        String teacherName = scanner.nextLine();
        //Output the search results to the console
        List<Teacher> teachers = Collections.getTeachers().stream().filter(teacher -> teacher.getName().contains(teacherName)).collect(Collectors.toList());

        System.out.println(teachers);
    }

    /**
     * Search test method
     */
    public static void searchNameTest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name test for searching");
        String testName = scanner.nextLine();
        //Output the search results to the console
        List<Tests> tests = Collections.getTests().stream().filter(test -> test.getTestName().contains(testName)).collect(Collectors.toList());

        System.out.println(tests);
    }



}







