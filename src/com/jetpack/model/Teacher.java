package com.jetpack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class teacher
 *
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class Teacher extends Users implements Serializable {

    /**Unique indicator for serializable class*/
    private static final long serialVersionUID = 1L;
    /**Teacher's subject name*/
    private String subject;
    /**Test name from test collection*/
    private  ArrayList<Tests> testName;
    /**Result test from result collection*/
    private  ArrayList<Result> result;
    /**Student name from student collection*/
    private  ArrayList<Student> students;

    /**
     * Constructor for create student collection
     * @param id - teacher index
     * @param name - teacher name
     * @param subject - teacher's subject name
     * @param testName - test name from test collection
     * @param result - student results
     * */
    public Teacher(int id, String name, String subject, ArrayList<Tests> testName, ArrayList<Result> result) {
        super(id, name);
        this.subject = subject;
        this.testName = testName;
        this.result = result;
    }

    /**
     * Constructor for create teacher collection from files
     * @param value - data from the file passed into the array
     * */
    public Teacher(String[] value) {
        super(Integer.parseInt(value[0]),value[1]);
        this.setId(Integer.parseInt(value[0]));
        this.setName(value[1]);
        this.subject = value[2];
        fillTestsFromStringValuesTeacher(value);
    }

    /**Empty constructor*/
    public Teacher() {

    }

    /**
     * Method for reading test data from a file into the teacher collection
     * @param value - data from the file passed into the array
     * */
    public void fillTestsFromStringValuesTeacher(String[] value){
        //Reading test data into a teacher collection from a file
        ArrayList<Tests> teacherTests = new ArrayList<>();
        for (int i = 3; i < value.length-5; i+=2){
            Tests test = new Tests();
            test.setTestName(value[i]);
            test.setNumberOfQuestions(Integer.parseInt(value[i+1]));
            teacherTests.add(test);
        }
        this.testName = teacherTests;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String getSubject() {
        return subject;
    }

    public ArrayList<Tests> getTestName() {
        return testName;
    }

    public ArrayList<Result> getResult() {
        return result;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTestName(ArrayList<Tests> testName) {
        this.testName = testName;
    }

    public void setResult(ArrayList<Result> result) {
        this.result = result;
    }

    @Override
    public String toString() {

        List<String> nameTest = new ArrayList<>();
        for (int i = 0; i < testName.size() ; i++) {
            testName.get(i).getTestName();
            nameTest.add(testName.get(i).getTestName());
        }

        List<String> nameStudent = new ArrayList<>();
        for (int i = 0; i < students.size() ; i++) {
            students.get(i).getName();
            nameStudent.add(students.get(i).getName());
        }

        return "Teacher{" + "id = " + getId() + " name = " + getName() +
                " subject = " + subject + '\'' +
                ", testName = " + nameTest +
                ", students = " + nameStudent +
                '}';
    }
}





