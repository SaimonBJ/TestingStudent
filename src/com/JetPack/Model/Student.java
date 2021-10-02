package com.JetPack.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends Users implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Tests> tests;
    private int studentsGroup;

    public Student(int id, String name, ArrayList<Tests> tests,  int studentsGroup) {

        super(id,name);
        this.tests = tests;
        this.studentsGroup = studentsGroup;
    }

    public Student(String[] value) {
        super(Integer.parseInt(value[0]), value[1]);
        this.setId(Integer.parseInt(value[0]));
        this.setName(value[1]);
        fillTestsFromStringValues(value);
        this.studentsGroup = Integer.parseInt(value[13]);
    }

    public Student() {

    }

    public void fillTestsFromStringValues(String value[]){
        //Reading tests data into a student collection from a file
       ArrayList<Tests> studentTests = new ArrayList<>();
       for (int i = 2; i < value.length-1; i+=2){
               Tests test = new Tests();
               test.setTestName(value[i]);
               test.setNumberOfQuestions(Integer.parseInt(value[i+1]));
           studentTests.add(test);
       }
       this.tests = studentTests;
    }




    public int getStudentsGroup() {
        return studentsGroup;
    }

    public void setStudentsGroup(int studentsGroup) {
        this.studentsGroup = studentsGroup;
    }

    public ArrayList<Tests> getTests() {
        return tests;
    }

    public void setTestName(ArrayList<Tests> tests) {
        this.tests = tests;
    }





}






