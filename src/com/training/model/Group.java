package com.training.model;

import java.util.ArrayList;


public class Group {
    private int id;
    private String groupName;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;

    public Group(int id, String groupName, ArrayList<Student> students, ArrayList<Teacher> teachers) {
        this.id = id;
        this.groupName = groupName;
        this.students = students;
        this.teachers = teachers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

}
