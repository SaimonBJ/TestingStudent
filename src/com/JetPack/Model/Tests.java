package com.JetPack.Model;

import java.io.Serializable;
import java.util.ArrayList;



public class Tests implements Serializable {
    private static final long serialVersionUID = 1L;
    private int testId;
    private int teacherId;
    private ArrayList<Teacher> teacherName;
    private String testName;
    private int numberOfQuestions;

    public Tests(int testId, int teacherId, ArrayList<Teacher> teacherName, String testName, int numberOfQuestions) {
        this.testId = testId;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.testName = testName;
        this.numberOfQuestions = numberOfQuestions;
    }

    public Tests(String[] value) {
       this.testId = Integer.parseInt(value[0]);
       this.teacherId = Integer.parseInt(value[1]);
       fillTeacherFromStringValues(value);
       this.testName = value[3];
       this.numberOfQuestions = Integer.parseInt(value[4]);
    }

    public Tests(){

    }

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
        return
                "testName='" + testName + '\'' +
                ", numberOfQuestions=" + numberOfQuestions;
    }
}

