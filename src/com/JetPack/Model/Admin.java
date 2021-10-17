package com.JetPack.Model;

import com.JetPack.DataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Users implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Teacher> teacherName;
    private ArrayList<Student> studentName;

    public Admin(int id, String name, ArrayList<Teacher> teachers, ArrayList<Student> students) {
        super(id, name);
        this.teacherName = teachers;
        this.studentName = students;
    }

    public Admin(String[] value) {
        super(Integer.parseInt(value[0]), value[1]);
        fillTeacherFromStringValues(value);
        fillStudentFromStringValues(value);
    }

    public Admin() {

    }


    public void fillTeacherFromStringValues(String[] value){
        //Reading teacher data into admin collection from a file
        ArrayList<Teacher> teachersList = new ArrayList<>();
        for (int i = 2; i < value.length-10; i++){
            Teacher teacher = new Teacher();
            teacher.setName(value[i]);
            teachersList.add(teacher);
        }
        this.teacherName = teachersList;
    }

    public void fillStudentFromStringValues(String[] value){
        //Reading student data into admin collection from a file
        ArrayList<Student> studentsList = new ArrayList<>();
        for (int i = 4; i < value.length; i++){
            Student student = new Student();
            student.setName(value[i]);
            studentsList.add(student);
        }
        this.studentName = studentsList;
    }

    public ArrayList<Teacher> getTeachers() {
        return teacherName;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teacherName = teachers;
    }

    public ArrayList<Student> getStudents() {
        return studentName;
    }

    public void setStudents(ArrayList<Student> students) {
        this.studentName = students;
    }

    @Override
    public String toString() {

        List<String> nameStudent = new ArrayList<>();
        for (int i = 0; i < studentName.size() ; i++) {
            studentName.get(i).getName();
            nameStudent.add(studentName.get(i).getName());
        }

        List<String> nameTeacher = new ArrayList<>();
        for (int i = 0; i < teacherName.size() ; i++) {
            teacherName.get(i).getName();
            nameTeacher.add(teacherName.get(i).getName());
        }

        return "Admin{"  + "id = " + getId() + ", name = " + getName() +
                ", teachers=" + nameTeacher +
                ", students=" + nameStudent +
                '}';
    }

}

