package com.JetPack.Model;

import com.JetPack.Exception.IncorrectUserNameException;

import java.util.ArrayList;

public class Teacher extends Users {

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





