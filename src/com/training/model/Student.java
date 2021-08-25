package com.training.model;

import java.awt.*;
import java.util.ArrayList;

public class Student extends Users {

    private ArrayList<Tests> testName;
    private ArrayList<Tests> numberOfQuestions;
    private int studentsGroup;

    public Student(int id, String name, ArrayList<Tests> testName, ArrayList<Tests> numberOfQuestions, int studentsGroup) {
        super(id, name);
        this.testName = testName;
        this.numberOfQuestions = numberOfQuestions;
        this.studentsGroup = studentsGroup;
    }


    public int getStudentsGroup() {
        return studentsGroup;
    }

    public void setStudentsGroup(int studentsGroup) {
        this.studentsGroup = studentsGroup;
    }

    public ArrayList<Tests> getTestName() {
        return testName;
    }

    public ArrayList<Tests> getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setTestName(ArrayList<Tests> testName) {
        this.testName = testName;
    }

    public void setNumberOfQuestions(ArrayList<Tests> numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }


}






