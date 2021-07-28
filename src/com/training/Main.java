package com.training;

import com.training.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Tests> tests = new ArrayList<>();
    static ArrayList<Result> results = new ArrayList<>();









    public static void main(String[] args) {
        initData();

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите свою должность тренинг центра: Student, Teacher or Admin");
        String positionInCenter = scan.nextLine();


        switch (positionInCenter) {
            case ("Student"):
                getStudentData();
                break;

            case ("Teacher"):
                getTeacherData();
                break;

            case ("Admin"):
                getAdminData();
                break;

            default:
                System.out.println("Error: в базе нет данных пользователей!");

        }

    }



    //View profile User Student
    public static void getStudentData(){
        Scanner scan = new Scanner(System.in);
        System.out.println("ВВедите свое имя, чтобы посмотреть свои данные: ");
        String st1 = scan.nextLine();
        for (Student st : students) {
            if (st.getName().equals(st1)) {
                System.out.println("У студента " + st.getName() + " есть такой список тестов :");
                for (int i = 0; i < st.getTestName().size(); i++) {
                    System.out.println(i + 1 + ". " + st.getTestName().get(i).getTestName() + " ,количество вопросов по тесту - " + st.getNumberOfQuestions().get(i).getNumberOfQuestions());
                }
                break;
            }
            else {
                System.out.println("Error: в тренинг центре нет учеников с таким именем!");
            }
            break;
        }

    }

    //View profile User Teacher
    public static void getTeacherData(){
        Scanner scan = new Scanner(System.in);
        System.out.println("ВВедите свое имя, чтобы посмотреть свои данные: ");
        String tch1 = scan.nextLine();
        for (int i = 0; i < teachers.size(); i++){
            if (teachers.get(i).getName().equals(tch1)){
                System.out.println("Список тестов учителя " + tch1 + ":");
                for (int a = 0; a <tests.size(); a++){
                    if (tests.get(a).getTeacherId() == teachers.get(i).getId()){
                        System.out.println(a + 1 + ". " + tests.get(a).getTestName());
                    }

                }
                System.out.println("Результаты учеников:");
                for (int a = 0; a < results.size(); a++) {
                    if (results.get(a).getTeacherId() == teachers.get(i).getId()) {
                        System.out.println(students.get(results.get(a).getStudentsId() - 1).getName() + " - " + tests.get(results.get(a).getTestId() - 1).getTestName() + " - " + results.get(a).getResult());
                    }

                }


            }
            else {
                System.out.println("Error: в тренинг центре нет учителей с таким именем!");
            }
            break;
        }

    }

    //View profile User Admin
    public static void getAdminData(){
       for (Admin administrator:admins){
            System.out.println("В системе есть такие пользователи ");

            for (int i = 0; i < administrator.getStudents().size(); i++) {

                System.out.println( i + 1 + ".Студент " +  administrator.getStudents().get(i).getName());
            }
            for (int i = 0; i < administrator.getTeachers().size(); i++) {

                System.out.println( i + 1 + ".Учитель " +  administrator.getTeachers().get(i).getName());
            }

        }
    }








          public static void initData() {

        //Students
        students.add(new Student(1, "John",tests,tests));
        students.add(new Student(2, "Mike",tests,tests));
        students.add(new Student(3, "Saimon",tests,tests));
        students.add(new Student(4, "Linda",tests,tests));
        students.add(new Student(5, "Amanda",tests,tests));
        students.add(new Student(6, "Floyd",tests,tests));
        students.add(new Student(7, "Stiven",tests,tests));
        students.add(new Student(8, "Peter",tests,tests));
        students.add(new Student(9, "Elena",tests,tests));
        students.add(new Student(10, "Maria",tests,tests));

        //Teachers
        teachers.add(new Teacher(1,"Mrs.Jones", "Math", tests, results));
        teachers.add(new Teacher(2,"Mr.Andersen", "Chemistry",tests, results));

        //Admin

        admins.add(new Admin(1,"Mark Zuckerberg",teachers, students));

        //Tests
        tests.add(new Tests(1,1,teachers,"Differential Equations Diagnostic Tests",100));
        tests.add(new Tests(2,1,teachers,"College Algebra Diagnostic Tests",50));
        tests.add(new Tests(3,1,teachers,"Basic Arithmetic Diagnostic Tests",70));
        tests.add(new Tests(4,2,teachers,"Chemical Formulas",20));
        tests.add(new Tests(5,2,teachers,"Concentration and Molarity",40));
        tests.add(new Tests(6,2,teachers,"Equilibrium Constants",25));

        //Test results
        results.add(new Result(1,1,1,teachers,1,5));
        results.add(new Result(2,2,1,teachers,2,4));
        results.add(new Result(3,3,1,teachers,3,3));
        results.add(new Result(4,4,2,teachers,4,3));
        results.add(new Result(5,5,2,teachers,5,2));
        results.add(new Result(6,6,2,teachers,6,4));
        results.add(new Result(7,7,1,teachers,1,5));
        results.add(new Result(8,8,1,teachers,2,5));
        results.add(new Result(9,9,1,teachers,3,5));
        results.add(new Result(10,10,2,teachers,4,3));
        results.add(new Result(11,4,1,teachers,1,3));
        results.add(new Result(12,5,1,teachers,2,4));
        results.add(new Result(13,7,2,teachers,5,3));
        results.add(new Result(14,2,2,teachers,6,4));
    }



    }







