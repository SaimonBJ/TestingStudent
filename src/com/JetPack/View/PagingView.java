package com.JetPack.View;

import com.JetPack.DataBase;
import com.JetPack.Exception.IncorrectUserNameException;
import com.JetPack.Model.Result;
import com.JetPack.Model.Student;
import com.JetPack.Model.Teacher;
import com.JetPack.Model.Tests;
import java.util.Comparator;
import java.util.Scanner;



public class PagingView {

    public static void viewPagingListTestStudent(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of lines on the page:");
        int pagingTest = scanner.nextInt();
        long page = 0;


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

            DataBase.getTests().sort(Comparator.comparing(Tests::getTestName));

            DataBase.getTests().stream().distinct().skip(page * pagingTest).limit(pagingTest).forEach(Tests -> System.out.println("Test name: " + Tests.getTestName() + ", numberOfQuestion: " + Tests.getNumberOfQuestions()));

            System.out.println("For view next page enter - Next\nFor view previous page enter - Previous\nFor exit main menu enter - Menu\nTo exit the program enter - Exit");
            if (scannerPage.equals("Exit"))
                break;

            }
        }

    public static void viewPagingListResult(){
        boolean foundTeacher = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String teacherName = scanner.nextLine();
        System.out.println("Enter the number of lines on the page:");
        int pagingTest = scanner.nextInt();
        long page = 0;


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

            for (Teacher teacher : DataBase.getTeachers()) {
                if (teacher.getName().equals(teacherName)){
                    foundTeacher = true;
                    DataBase.getResults().sort(Comparator.comparing(Result::getResult));
                    DataBase.getResults().stream().filter(result -> result.getTeacherId() == teacher.getId()).skip(page * pagingTest).limit(pagingTest).forEach(result -> System.out.println("In group: " + DataBase.getGroups().get(result.getStudentsGroupId() - 1).getGroupName() + ", student -  " + DataBase.getStudents().get(result.getStudentsId() - 1).getName() + " , rated - " + " - " + result.getResultMap()));
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

    public static void viewPagingListTestTeacher(){
        boolean foundTeacher = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String teacherName = scanner.nextLine();
        System.out.println("Enter the number of lines on the page:");
        int pagingTest = scanner.nextInt();
        long page = 0;


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

            for (Teacher teacher : DataBase.getTeachers()) {
                if (teacher.getName().equals(teacherName)){
                    foundTeacher = true;
                    DataBase.getTests().sort(Comparator.comparing(Tests::getTestName));
                    DataBase.getTests().stream().filter(tests -> tests.getTeacherId() == teacher.getId()).distinct().skip(page * pagingTest).limit(pagingTest).forEach(Tests -> System.out.println("Test name: " + Tests.getTestName()));
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

    public static void viewPagingListStudent(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of lines on the page:");
        int pagingTest = scanner.nextInt();
        long page = 0;


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

            DataBase.getStudents().sort(Comparator.comparing(Student::getName));

            DataBase.getStudents().stream().map(Student::getName).distinct().skip(page * pagingTest).limit(pagingTest).forEach(System.out::println);

            System.out.println("For view next page enter - Next\nFor view previous page enter - Previous\nFor exit main menu enter - Menu");
        }
    }

    public static void viewPagingListTeacher(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of lines on the page:");
        int pagingTest = scanner.nextInt();
        long page = 0;


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

            DataBase.getTeachers().sort(Comparator.comparing(Teacher::getName));

            DataBase.getTeachers().stream().map(Teacher::getName).distinct().skip(page * pagingTest).limit(pagingTest).forEach(System.out::println);

            System.out.println("For view next page enter - Next\nFor view previous page enter - Previous\nFor exit main menu enter - Menu");
        }
    }


    }




