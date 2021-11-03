package com.jetpack.view;

import com.jetpack.controller.TestCont;
import com.jetpack.Collections;
import com.jetpack.exception.IncorrectUserNameException;
import com.jetpack.model.Student;
import java.util.Scanner;
import static com.jetpack.view.PagingView.viewPagingListTestStudent;
import static com.jetpack.view.SearchView.searchNameTest;

/**
 * Outputting information for the student
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class StudentView {

    /**
     * Method outputting information for the student
     * @throws IncorrectUserNameException - the user entered the wrong name
     */
    public static void getStudentData(){
            boolean foundStudent = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name: ");
            String personName = scanner.nextLine();
        for (Student student : Collections.getStudents()){
            if (student.getName().equals(personName)){
                foundStudent = true;
                System.out.println("View full list of users enter - All\nView user list page by page enter - Page\nFind a user by name enter - Search");
                String input = scanner.nextLine();
                switch (input) {
                    //View all data student: list tests and number of questions.
                    case "All":
                        System.out.println("Student " + student.getName() + " has a list of tests:");
                        for (int i = 0; i < student.getTests().size(); i++) {
                            System.out.println(i + 1 + ". " + student.getTests().get(i).getTestName() + " ,number of questions on the test - " + student.getTests().get(i).getNumberOfQuestions());
                        }
                        break;
                    //Paging all data student: list tests and number of questions.
                    case "Page":
                        viewPagingListTestStudent();
                        break;
                    //Search all data student: list tests and number of questions.
                    case "Search":
                        searchNameTest();
                        break;
                    default:
                        getStudentData();
                        break;
                }
            }
        }

        try {
            IncorrectUserNameException.checkValidNameStudent(foundStudent);
        } catch (IncorrectUserNameException e) {
            e.printStackTrace();
            getStudentData();
        }
         //Going to test solutions
        TestCont.getStartTestQuestions();
    }





}
