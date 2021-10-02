package com.JetPack.Model;

import com.JetPack.DataBase;

import java.io.Serializable;
import java.util.ArrayList;

public class Admin extends Users implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;

    public Admin(int id, String name, ArrayList<Teacher> teachers, ArrayList<Student> students) {
        super(id, name);
        this.teachers = teachers;
        this.students = students;
    }

    public Admin(String[] value) {
        super(Integer.parseInt(value[0]), value[1]);
        fillTeacherFromStringValues(value);
        fillStudentFromStringValues(value);
    }


    public void fillTeacherFromStringValues(String[] value){
        //Reading teacher data into admin collection from a file
        ArrayList<Teacher> teachersList = new ArrayList<>();
        for (int i = 2; i < value.length-10; i++){
            Teacher teacher = new Teacher();
            teacher.setName(value[i]);
            teachersList.add(teacher);
        }
        this.teachers = teachersList;
    }

    public void fillStudentFromStringValues(String[] value){
        //Reading student data into admin collection from a file
        ArrayList<Student> studentsList = new ArrayList<>();
        for (int i = 4; i < value.length; i++){
            Student student = new Student();
            student.setName(value[i]);
            studentsList.add(student);
        }
        this.students = studentsList;
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

