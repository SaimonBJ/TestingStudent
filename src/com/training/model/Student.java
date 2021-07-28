package com.training.model;

import java.awt.*;
import java.util.ArrayList;

public class Student extends Users {

    private ArrayList<Tests> testName;
    private ArrayList<Tests> numberOfQuestions;


    public Student(int id, String name, ArrayList<Tests> testName, ArrayList<Tests> numberOfQuestions) {
        super(id, name);
        this.testName = testName;
        this.numberOfQuestions = numberOfQuestions;
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






