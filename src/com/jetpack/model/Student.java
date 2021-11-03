package com.jetpack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class student
 *
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */

public class Student extends Users implements Serializable {

    /**Unique indicator for serializable class*/
    private static final long serialVersionUID = 1L;
    /**Student group number*/
    private int studentsGroup;
    /**Test name from test collection*/
    private List<Tests> testName = Collections.emptyList();

    /**
     * Constructor for create student collection
     * @param id - student index
     * @param name - student name
     * @param testName - test name from test collection
     * @param studentsGroup - student group number
     * */
    public Student(int id, String name, ArrayList<Tests> testName,  int studentsGroup) {

        super(id,name);
        this.testName = testName;
        this.studentsGroup = studentsGroup;
    }

    /**
     * Constructor for create student collection from files
     * @param value - data from the file passed into the array
     * */
    public Student(String[] value) {
        super(Integer.parseInt(value[0]), value[1]);
        this.setId(Integer.parseInt(value[0]));
        this.setName(value[1]);
        fillTestsFromStringValues(value);
        this.studentsGroup = Integer.parseInt(value[13]);
    }

    /**Empty constructor*/
    public Student() {

    }

    /**
     * Method for reading test data from a file into the student collection
     * @param value - data from the file passed into the array
     * */
    public void fillTestsFromStringValues(String value[]){
        //Reading tests data into a student collection from a file
       ArrayList<Tests> studentTests = new ArrayList<>();
       for (int i = 2; i < value.length-1; i+=2){
               Tests test = new Tests();
               test.setTestName(value[i]);
               test.setNumberOfQuestions(Integer.parseInt(value[i+1]));
           studentTests.add(test);
       }
       this.testName = studentTests;
    }




    public int getStudentsGroup() {
        return studentsGroup;
    }

    public void setStudentsGroup(int studentsGroup) {
        this.studentsGroup = studentsGroup;
    }

    public List<Tests> getTests() {
        return testName;
    }

    public void setTestName(ArrayList<Tests> tests) {
        this.testName = tests;
    }

    @Override
    public String toString() {
        List<String> nameTest = new ArrayList<>();
        for (int i = 0; i < testName.size() ; i++) {
            testName.get(i).getTestName();
            nameTest.add(testName.get(i).getTestName());
        }
        return "Student{" + "id = " + getId() + " name = " + getName() +
                " tests=" + nameTest +
                ", studentsGroup = " + studentsGroup +
                '}';
    }
}






