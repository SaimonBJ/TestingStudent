package com.jetpack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class tests
 *
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */

public class Tests implements Serializable {
    /**Unique indicator for serializable class*/
    private static final long serialVersionUID = 1L;
    /**Test id*/
    private int testId;
    /**Teacher id*/
    private int teacherId;
    /**Student name from student collection*/
    private ArrayList<Teacher> teacherName;
    /**Test name*/
    private String testName;
    /**Number of questions in the test*/
    private int numberOfQuestions;

    /**
     * Constructor for create tests collection
     * @param testId - test index
     * @param teacherId - teacher index
     * @param teacherName - Teacher name from teacher collection
     * @param testName - test name
     * @param numberOfQuestions - number of questions in the test
     * */
    public Tests(int testId, int teacherId, ArrayList<Teacher> teacherName, String testName, int numberOfQuestions) {
        this.testId = testId;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.testName = testName;
        this.numberOfQuestions = numberOfQuestions;
    }

    /**
     * Constructor for create test collection from files
     * @param value - data from the file passed into the array
     * */
    public Tests(String[] value) {
       this.testId = Integer.parseInt(value[0]);
       this.teacherId = Integer.parseInt(value[1]);
       fillTeacherFromStringValues(value);
       this.testName = value[3];
       this.numberOfQuestions = Integer.parseInt(value[4]);
    }

    /**Empty constructor*/
    public Tests(){

    }

    /**
     * Method for reading teacher data from a file into the test collection
     * @param value - data from the file passed into the array
     * */
    public void fillTeacherFromStringValues(String[] value){
        //Reading teacher data into a test collection from a file
        ArrayList<Teacher> teachersList = new ArrayList<>();
        for (int i = 2; i < value.length-2; i++){
            Teacher teacher = new Teacher();
            teacher.setName(value[i]);
            teachersList.add(teacher);
        }
        this.teacherName = teachersList;
    }


    public ArrayList<Teacher> getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(ArrayList<Teacher> teacherName) {
        this.teacherName = teacherName;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }


    public int getTestId() {
        return testId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getTestName() {
        return testName;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    @Override
    public String toString() {

        List<String> nameTeacher = new ArrayList<>();
        for (int i = 0; i < teacherName.size() ; i++) {
            teacherName.get(i).getName();
            nameTeacher.add(teacherName.get(i).getName());
        }

        return "Tests{" +
                "testId=" + testId +
                ", teacherId=" + teacherId +
                ", teacherName=" + nameTeacher +
                ", testName='" + testName + '\'' +
                ", numberOfQuestions=" + numberOfQuestions +
                '}';
    }
}

