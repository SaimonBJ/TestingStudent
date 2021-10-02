package com.JetPack.Model;

import com.JetPack.Exception.IncorrectUserNameException;

import java.io.Serializable;
import java.util.ArrayList;


public class Teacher extends Users implements Serializable {
    private static final long serialVersionUID = 1L;
    private String subject;
    private  ArrayList<Tests> testName;
    private  ArrayList<Result> result;
    private  ArrayList<Student> students;
    public Teacher(int id, String name, String subject, ArrayList<Tests> testName, ArrayList<Result> result) {
        super(id, name);
        this.subject = subject;
        this.testName = testName;
        this.result = result;
    }

    public Teacher(int id, String name, ArrayList<Student> students) throws IncorrectUserNameException {
        super(id, name);
        this.students = students;
    }

    public Teacher(String[] value) {
        super(Integer.parseInt(value[0]),value[1]);
        this.setId(Integer.parseInt(value[0]));
        this.setName(value[1]);
        this.subject = value[2];
        fillTestsFromStringValuesTeacher(value);
    }

    public Teacher() {

    }

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


}





