package com.jetpack.view;

import com.jetpack.menu.TeacherMenu;
import com.jetpack.Collections;
import com.jetpack.exception.IncorrectUserNameException;
import com.jetpack.model.Result;
import com.jetpack.model.Teacher;
import java.util.Comparator;
import java.util.Scanner;
import static com.jetpack.view.PagingView.viewPagingListResult;
import static com.jetpack.view.PagingView.viewPagingListTestTeacher;
import static com.jetpack.view.SearchView.searchNameTest;

/**
 * Outputting information for the teacher
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class TeacherView {
    /**
     * Method outputting information for the teacher
     * @throws IncorrectUserNameException - the user entered the wrong name
     */
    public static void getTeacherData(){
        boolean foundTeacher = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("View full list of users enter - All\nView user list page by page enter - Page\nFind a user by name enter - Search");
        String input = scanner.nextLine();

                System.out.println("Enter your name: ");
                String personName = scanner.nextLine();
                for (Teacher teacher : Collections.getTeachers()) {
                    if (teacher.getName().equals(personName)) {
                        foundTeacher = true;
                        switch (input) {
                            //View all data teacher: list tests and results.
                            case "All":
                            System.out.println("Teacher Test List " + personName + ":");
                            for (int j = 0; j < Collections.getTests().size(); j++) {
                                if (Collections.getTests().get(j).getTeacherId() == teacher.getId()) {
                                    System.out.println(j + 1 + ". " + Collections.getTests().get(j).getTestName());
                                }
                            }
                            Collections.getResults().sort(Comparator.comparing(Result::getResult).reversed());
                            System.out.println("Students results:");
                            for (Result result : Collections.getResults()) {
                                if (result.getTeacherId() == teacher.getId()) {
                                    System.out.println("In group: " + Collections.getGroups().get(result.getStudentsGroupId() - 1).getGroupName() +
                                            ", student -  " + Collections.getStudents().get(result.getStudentsId() - 1).getName() + " , rated - " + " - " + result.getResultMap());
                                }
                            }
                            break;
                            //Paging all data teacher: list tests and results.
                            case "Page":
                                System.out.println("Do you want to see tests or results?\nIf tests, enter - Test\nIf result, enter - Result");
                                String changeInput = scanner.nextLine();
                                if (changeInput.equals("Test")){
                                    viewPagingListTestTeacher();
                                }
                                else if (changeInput.equals("Result")){
                                    viewPagingListResult();
                                }
                                break;
                            //Search all data teacher: list tests and results.
                            case "Search":
                                searchNameTest();
                                break;
                            default:
                                getTeacherData();
                                break;
                        }
                }
        }

        try {
            IncorrectUserNameException.checkValidNameTeacher(foundTeacher);
        } catch (IncorrectUserNameException e) {
            e.printStackTrace();
            getTeacherData();
        }
        //Going to teacher main menu
        TeacherMenu.contTeacher();
    }





}
