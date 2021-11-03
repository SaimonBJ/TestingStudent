package com.jetpack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class group
 *
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */


public class Group implements Serializable {

    /**Unique indicator for serializable class*/
    private static final long serialVersionUID = 1L;
    /**Group id*/
    private int id;
    /**Group name*/
    private String groupName;
    /**Student name from student collection*/
    private ArrayList<Student> students;
    /**Teacher name from teacher collection*/
    private ArrayList<Teacher> teachers;

    /**
     * Constructor for create group collection
     * @param id - group index
     * @param groupName - group name
     * @param teachers - Teacher name from teacher collection
     * @param students - Student name from student collection
     * */
    public Group(int id, String groupName, ArrayList<Student> students, ArrayList<Teacher> teachers) {
        this.id = id;
        this.groupName = groupName;
        this.students = students;
        this.teachers = teachers;
    }

    /**
     * Constructor for create group collection from files
     * @param value - data from the file passed into the array
     * */
    public Group(String[] value) {
        this.id = Integer.parseInt(value[0]);
        this.groupName = value[1];
        fillStudentFromStringValues(value);
        fillTeacherFromStringValues(value);
    }

    /**Empty constructor*/
    public Group() {

    }

    /**
     * Method for reading teacher data from a file into the group collection
     * @param value - data from the file passed into the array
     * */
    public void fillTeacherFromStringValues(String[] value){
        //Reading teacher data into a group collection from a file
        ArrayList<Teacher> teachersList = new ArrayList<>();
        for (int i = 7; i < value.length; i++){
            Teacher teacher = new Teacher();
            teacher.setName(value[i]);
            teachersList.add(teacher);
        }
        this.teachers = teachersList;
    }

    /**
     * Method for reading student data from a file into the group collection
     * @param value - data from the file passed into the array
     * */
    public void fillStudentFromStringValues(String[] value){
        //Reading student data into a group collection from a file
        ArrayList<Student> studentsList = new ArrayList<>();
        for (int i = 2; i < value.length-1; i++){
            Student student = new Student();
            student.setName(value[i]);
            studentsList.add(student);
        }
        this.students = studentsList;
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

    @Override
    public String toString() {

        List<String> nameStudent = new ArrayList<>();
        for (int i = 0; i < students.size() ; i++) {
            students.get(i).getName();
            nameStudent.add(students.get(i).getName());
        }

        List<String> nameTeacher = new ArrayList<>();
        for (int i = 0; i < teachers.size() ; i++) {
            teachers.get(i).getName();
            nameTeacher.add(teachers.get(i).getName());
        }

        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", students=" + nameStudent +
                ", teachers=" + nameTeacher +
                '}';
    }

}
