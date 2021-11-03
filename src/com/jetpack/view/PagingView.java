package com.jetpack.view;

import com.jetpack.Collections;
import com.jetpack.exception.IncorrectUserNameException;
import com.jetpack.model.Result;
import com.jetpack.model.Student;
import com.jetpack.model.Teacher;
import com.jetpack.model.Tests;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Paginated output information
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class PagingView {

    /**
     * Method page tests data output
     * @throws Exception - incorrect input
     */
    public static void viewPagingListTestStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of lines on the page:");
        int pagingTest = scanner.nextInt();
        long page = 0;

        //Page turning cycle
        while (true){
            String scannerPage = scanner.nextLine();

            try {
                switch (scannerPage){
                    case ("Next"):
                        page++;
                        break;

                    case ("Previous"):
                        page--;
                        break;

                    case ("Menu"):
                        UsersView.viewDataBase();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Sorting results
            Collections.getTests().sort(Comparator.comparing(Tests::getTestName));
            //Output the results to the console
            Collections.getTests().stream().distinct().skip(page * pagingTest).limit(pagingTest).forEach(Tests -> System.out.println("Test name: " + Tests.getTestName() + ", numberOfQuestion: " + Tests.getNumberOfQuestions()));

            System.out.println("For view next page enter - Next\nFor view previous page enter - Previous\nFor exit main menu enter - Menu\nTo exit the program enter - Exit");
            if (scannerPage.equals("Exit"))
                break;

            }
        }

    /**
     * Method page result data output
     * @throws Exception - incorrect input
     */
    public static void viewPagingListResult(){
        boolean foundTeacher = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String teacherName = scanner.nextLine();
        System.out.println("Enter the number of lines on the page:");
        int pagingTest = scanner.nextInt();
        long page = 0;

        //Page turning cycle
        while (true){
            String scannerPage = scanner.nextLine();

            try {
                switch (scannerPage){
                    case ("Next"):
                        page++;
                        break;

                    case ("Previous"):
                        page--;
                        break;

                    case ("Menu"):
                        UsersView.viewDataBase();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (Teacher teacher : Collections.getTeachers()) {
                if (teacher.getName().equals(teacherName)){
                    foundTeacher = true;
                    //Sorting results
                    Collections.getResults().sort(Comparator.comparing(Result::getResult));
                    //Output the results to the console
                    Collections.getResults().stream().filter(result -> result.getTeacherId() == teacher.getId()).skip(page * pagingTest).limit(pagingTest).forEach(result -> System.out.println("In group: " + Collections.getGroups().get(result.getStudentsGroupId() - 1).getGroupName() + ", student -  " + Collections.getStudents().get(result.getStudentsId() - 1).getName() + " , rated - " + " - " + result.getResultMap()));
                }
            }

            try {
                IncorrectUserNameException.checkValidNameTeacher(foundTeacher);
            } catch (IncorrectUserNameException e) {
                e.printStackTrace();
                viewPagingListTestTeacher();
            }

            System.out.println("For view next page enter - Next\nFor view previous page enter - Previous\nFor exit main menu enter - Menu");
        }
    }

    /**
     * Method page teacher data output
     * @throws Exception - incorrect input
     */
    public static void viewPagingListTestTeacher(){
        boolean foundTeacher = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String teacherName = scanner.nextLine();
        System.out.println("Enter the number of lines on the page:");
        int pagingTest = scanner.nextInt();
        long page = 0;

        //Page turning cycle
        while (true){
            String scannerPage = scanner.nextLine();


                switch (scannerPage){
                    case ("Next"):
                        page++;
                        break;

                    case ("Previous"):
                        page--;
                        break;

                    case ("Menu"):
                        UsersView.viewDataBase();
                        break;
                }

            for (Teacher teacher : Collections.getTeachers()) {
                if (teacher.getName().equals(teacherName)){
                    foundTeacher = true;
                    //Sorting results
                    Collections.getTests().sort(Comparator.comparing(Tests::getTestName));
                    //Output the results to the console
                    Collections.getTests().stream().filter(tests -> tests.getTeacherId() == teacher.getId()).distinct().skip(page * pagingTest).limit(pagingTest).forEach(Tests -> System.out.println("Test name: " + Tests.getTestName()));
                }
            }

            try {
                IncorrectUserNameException.checkValidNameTeacher(foundTeacher);
            } catch (IncorrectUserNameException e) {
                e.printStackTrace();
                viewPagingListTestTeacher();
            }

            System.out.println("For view next page enter - Next\nFor view previous page enter - Previous\nFor exit main menu enter - Menu\nTo exit the program enter - Exit");
            if (scannerPage.equals("Exit"))
                break;

        }
    }

    /**
     * Method page student data output
     * @throws Exception - incorrect input
     */
    public static void viewPagingListStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of lines on the page:");
        int pagingTest = scanner.nextInt();
        long page = 0;

        //Page turning cycle
        while (true){
            String scannerPage = scanner.nextLine();

            try {
                switch (scannerPage){
                    case ("Next"):
                        page++;
                        break;

                    case ("Previous"):
                        page--;
                        break;

                    case ("Menu"):
                        UsersView.viewDataBase();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Sorting results
            Collections.getStudents().sort(Comparator.comparing(Student::getName));
            //Output the results to the console
            Collections.getStudents().stream().map(Student::getName).distinct().skip(page * pagingTest).limit(pagingTest).forEach(System.out::println);

            System.out.println("For view next page enter - Next\nFor view previous page enter - Previous\nFor exit main menu enter - Menu");
        }
    }

    /**
     * Method page teacher data output
     * @throws Exception - incorrect input
     */
    public static void viewPagingListTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of lines on the page:");
        int pagingTest = scanner.nextInt();
        long page = 0;

        //Page turning cycle
        while (true){
            String scannerPage = scanner.nextLine();

            try {
                switch (scannerPage){
                    case ("Next"):
                        page++;
                        break;

                    case ("Previous"):
                        page--;
                        break;

                    case ("Menu"):
                        UsersView.viewDataBase();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Sorting results
            Collections.getTeachers().sort(Comparator.comparing(Teacher::getName));
            //Output the results to the console
            Collections.getTeachers().stream().map(Teacher::getName).distinct().skip(page * pagingTest).limit(pagingTest).forEach(System.out::println);

            System.out.println("For view next page enter - Next\nFor view previous page enter - Previous\nFor exit main menu enter - Menu");
        }
    }
    }




