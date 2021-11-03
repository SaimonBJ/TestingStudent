package com.jetpack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class administrator
 *
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */

public class Admin extends Users implements Serializable {

    /**Unique indicator for serializable class*/
    private static final long serialVersionUID = 1L;
    /**Teacher name from teacher collection*/
    private ArrayList<Teacher> teacherName;
    /**Student name from student collection*/
    private ArrayList<Student> studentName;

    /**
     * Constructor for create admin collection
     * @param id - admin index
     * @param name - admin name
     * @param teachers - Teacher name from teacher collection
     * @param students - Student name from student collection
     * */
    public Admin(int id, String name, ArrayList<Teacher> teachers, ArrayList<Student> students) {
        super(id, name);
        this.teacherName = teachers;
        this.studentName = students;
    }

    /**
     * Constructor for create admin collection from files
     * @param value - data from the file passed into the array
     * */
    public Admin(String[] value) {

        super(Integer.parseInt(value[0]), value[1]);
        fillTeacherFromStringValues(value);
        fillStudentFromStringValues(value);
    }

    /**Empty constructor*/
    public Admin() {

    }

    /**
     * Method for reading teacher data from a file into the admin collection
     * @param value - data from the file passed into the array
     * */
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

    /**
     * Method for reading student data from a file into the admin collection
     * @param value - data from the file passed into the array
     * */
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

