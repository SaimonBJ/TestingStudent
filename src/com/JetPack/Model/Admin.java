package com.JetPack.Model;

import java.util.ArrayList;

public class Admin extends Users{

    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;

    public Admin(int id, String name, ArrayList<Teacher> teachers, ArrayList<Student> students) {
        super(id, name);
        this.teachers = teachers;
        this.students = students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }


}

