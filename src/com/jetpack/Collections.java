package com.jetpack;


import com.jetpack.model.*;
import java.util.ArrayList;

/**
 * Class collections containing all data
 *
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class Collections {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Group> groups = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Tests> tests = new ArrayList<>();
    static ArrayList<Question> questions = new ArrayList<>();
    static ArrayList<Result> results = new ArrayList<>();

        /**
         * Method accepting the given student into the collection
         * @param student  - data students
         * */
        public static void addStudent(Student student){
            students.add(student);
        }

        /**
         * Method accepting the given teacher into the collection
         * @param teacher  - data students
         * */
        public static void addTeacher(Teacher teacher){
            teachers.add(teacher);
        }

        /**
         * Method accepting the given admin into the collection
         * @param admin  - data students
         * */
        public static void addAdmin(Admin admin){
        admins.add(admin);
        }

        /**
         * Method accepting the given group into the collection
         * @param group  - data students
         * */
        public static void addGroup(Group group){
        groups.add(group);
        }

        /**
         * Method accepting the given test into the collection
         * @param test  - data students
         * */
        public static void addTest(Tests test){
        tests.add(test);
        }

        /**
         * Method accepting the given result into the collection
         * @param result  - data students
         * */
        public static void addResult(Result result){
        results.add(result);
        }

        /**
         * Method accepting the given question into the collection
         * @param question  - data students
         * */
        public static void addQuestion(Question question){
        questions.add(question);
        }



    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        Collections.students = students;
    }

    public static ArrayList<Group> getGroups() {
        return groups;
    }

    public static void setGroups(ArrayList<Group> groups) {
        Collections.groups = groups;
    }

    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public static void setTeachers(ArrayList<Teacher> teachers) {
        Collections.teachers = teachers;
    }

    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

    public static void setAdmins(ArrayList<Admin> admins) {
        Collections.admins = admins;
    }

    public static ArrayList<Tests> getTests() {
        return tests;
    }

    public static void setTests(ArrayList<Tests> tests) {
        Collections.tests = tests;
    }

    public static ArrayList<Question> getQuestions() {
        return questions;
    }

    public static void setQuestions(ArrayList<Question> questions) {
        Collections.questions = questions;
    }

    public static ArrayList<Result> getResults() {
        return results;
    }

    public static void setResults(ArrayList<Result> results) {
        Collections.results = results;
    }
}
