package com.JetPack;


import com.JetPack.Model.*;
import java.util.ArrayList;




public class DataBase {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Group> groups = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Tests> tests = new ArrayList<>();
    static ArrayList<Question> questions = new ArrayList<>();
    static ArrayList<Result> results = new ArrayList<>();


        public static void addStudent(Student student){
            students.add(student);
        }
        public static void addTeacher(Teacher teacher){
            teachers.add(teacher);
        }
        public static void addAdmin(Admin admin){
        admins.add(admin);
        }
        public static void addGroup(Group group){
        groups.add(group);
        }
        public static void addTest(Tests test){
        tests.add(test);
        }
        public static void addResult(Result result){
        results.add(result);
        }
        public static void addQuestion(Question question){
        questions.add(question);
        }


    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        DataBase.students = students;
    }

    public static ArrayList<Group> getGroups() {
        return groups;
    }

    public static void setGroups(ArrayList<Group> groups) {
        DataBase.groups = groups;
    }

    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public static void setTeachers(ArrayList<Teacher> teachers) {
        DataBase.teachers = teachers;
    }

    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

    public static void setAdmins(ArrayList<Admin> admins) {
        DataBase.admins = admins;
    }

    public static ArrayList<Tests> getTests() {
        return tests;
    }

    public static void setTests(ArrayList<Tests> tests) {
        DataBase.tests = tests;
    }

    public static ArrayList<Question> getQuestions() {
        return questions;
    }

    public static void setQuestions(ArrayList<Question> questions) {
        DataBase.questions = questions;
    }

    public static ArrayList<Result> getResults() {
        return results;
    }

    public static void setResults(ArrayList<Result> results) {
        DataBase.results = results;
    }
}
