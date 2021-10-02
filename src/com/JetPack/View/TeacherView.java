package com.JetPack.View;

import com.JetPack.Controller.TeacherCont;
import com.JetPack.DataBase;
import com.JetPack.Exception.IncorrectUserNameException;
import com.JetPack.Model.Result;
import com.JetPack.Model.Teacher;
import java.util.Comparator;
import java.util.Scanner;
import static com.JetPack.View.PagingView.viewPagingListResult;
import static com.JetPack.View.PagingView.viewPagingListTestTeacher;
import static com.JetPack.View.SearchView.searchNameTest;


public class TeacherView {

    public static void getTeacherData(){
        boolean foundTeacher = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("View full list of users enter - All\nView user list page by page enter - Page\nFind a user by name enter - Search");
        String input = scanner.nextLine();

                System.out.println("Enter your name: ");
                String personName = scanner.nextLine();
                for (Teacher teacher : DataBase.getTeachers()) {
                    if (teacher.getName().equals(personName)) {
                        foundTeacher = true;
                        switch (input) {
                            //View all data teacher: list tests and results.
                            case "All":
                            System.out.println("Teacher Test List " + personName + ":");
                            for (int j = 0; j < DataBase.getTests().size(); j++) {
                                if (DataBase.getTests().get(j).getTeacherId() == teacher.getId()) {
                                    System.out.println(j + 1 + ". " + DataBase.getTests().get(j).getTestName());
                                }
                            }
                            DataBase.getResults().sort(Comparator.comparing(Result::getResult).reversed());
                            System.out.println("Students results:");
                            for (Result result : DataBase.getResults()) {
                                if (result.getTeacherId() == teacher.getId()) {
                                    System.out.println("In group: " + DataBase.getGroups().get(result.getStudentsGroupId() - 1).getGroupName() + ", student -  " + DataBase.getStudents().get(result.getStudentsId() - 1).getName() + " , rated - " + " - " + result.getResultMap());
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
        TeacherCont.contTeacher();
    }





}
