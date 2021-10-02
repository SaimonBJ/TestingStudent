package com.JetPack;


import com.JetPack.Model.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;



public class DataBase {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Group> groups = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Tests> tests = new ArrayList<>();
    static ArrayList<Question> questions = new ArrayList<>();
    static ArrayList<Result> results = new ArrayList<>();


//    static {
//
//        dataStudent();
//        dataTeacher();
//        dataAdmin();
//        dataQuestion();
//        dataGroup();
//        dataResult();
//        dataTest();
//
//    }


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

//    public static void dataStudent(){
//
//        students.add(new Student(1, "Mike Jones", tests,1));
//        students.add(new Student(2, "John Smith",tests,1));
//        students.add(new Student(3, "Saimon Peters",tests,1));
//        students.add(new Student(4, "Linda Ashby",tests,1));
//        students.add(new Student(5, "Amanda Simons",tests,1));
//        students.add(new Student(6, "Floyd Mayweather",tests,2));
//        students.add(new Student(7, "Stiven King",tests,2));
//        students.add(new Student(8, "Peter Parker",tests,2));
//        students.add(new Student(9, "Elena Stevens",tests,2));
//        students.add(new Student(10, "Maria Sharps",tests,2));
//
//    }
//
//    public static void dataGroup(){
//
//        groups.add(new Group(1, "Group-001", students, teachers));
//        groups.add(new Group(2, "Group-002", students, teachers));
//
//    }
//
//    public static void dataTeacher() {
//
//        teachers.add(new Teacher(1,"Mrs.Jones", "Math", tests, results));
//        teachers.add(new Teacher(2,"Mr.Andersen", "Chemistry",tests, results));
//
//    }
//
//    public static void dataAdmin()  {
//
//        admins.add(new Admin(1,"Mark Zuckerberg",teachers, students));
//
//    }
//
//    public static void dataResult(){
//
//        results.add(new Result(1,1,1,1,teachers,1,0, new HashMap<>()));
//        results.add(new Result(2,2,1,1,teachers,2,0, new HashMap<>()));
//        results.add(new Result(3,3,1,1,teachers,3,0, new HashMap<>()));
//        results.add(new Result(4,4,1,1,teachers,1,0, new HashMap<>()));
//        results.add(new Result(5,5,1,1,teachers,2,0, new HashMap<>()));
//        results.add(new Result(6,6,2,2,teachers,4,0, new HashMap<>()));
//        results.add(new Result(7,7,2,2,teachers,5,0, new HashMap<>()));
//        results.add(new Result(8,8,2,2,teachers,6,0, new HashMap<>()));
//        results.add(new Result(9,9,2,2,teachers,4,0, new HashMap<>()));
//        results.add(new Result(10,10,2,2,teachers,5,0, new HashMap<>()));
//
//    }
//
//
//
//    public static void dataTest(){
//
//        tests.add(new Tests(1,1,teachers,"Arithmetic tests",5));
//        tests.add(new Tests(2,1,teachers,"Elementary Algebra tests",4));
//        tests.add(new Tests(3,1,teachers,"Arithmetic equations tests",3));
//        tests.add(new Tests(4,2,teachers,"Chemical formulas",4));
//        tests.add(new Tests(5,2,teachers,"Valence of chemical elements",2));
//        tests.add(new Tests(6,2,teachers,"Molecular weight",3));
//
//    }
//
//    public static void dataQuestion() {
//
//        questions.add(new Question("Question 1 - Theme: Arithmetic tests: 2 + 2 = ?", Arrays.asList("1 option: 2", "2 option: 4", "3 option: 6"),  2));
//        questions.add(new Question("Question 2 - Theme: Arithmetic tests: 2 - 2 = ?", Arrays.asList("1 option: 0", "2 option: 1", "3 option: 2"),  1));
//        questions.add(new Question("Question 3 - Theme: Arithmetic tests: 2 * 2 = ?", Arrays.asList("1 option: 2", "2 option: 8", "3 option: 4"), 3));
//        questions.add(new Question("Question 4 - Theme: Arithmetic tests: 2 / 2 = ?", Arrays.asList("1 option: 1", "2 option: 2", "3 option: 0"),  1));
//        questions.add(new Question("Question 5 - Theme: Arithmetic tests: 2 + 4 = ?", Arrays.asList("1 option: 6", "2 option: 7", "3 option: 9"),  1));
//        questions.add(new Question("Question 6 - Theme: Elementary Algebra tests: 2 + 2 * 2 = ?", Arrays.asList("1 option: 10", "2 option: 8", "3 option: 6"),  3));
//        questions.add(new Question("Question 7 - Theme: Elementary Algebra tests: 2 + 2 / 2 = ?", Arrays.asList("1 option: 3", "2 option: 2", "3 option: 4"),  1));
//        questions.add(new Question("Question 8 - Theme: Elementary Algebra tests: 5 - 2 * 2 = ?", Arrays.asList("1 option: 1", "2 option: 6", "3 option: 3"),  1));
//        questions.add(new Question("Question 9 - Theme: Elementary Algebra tests: 2 - 2 / 2 = ?", Arrays.asList("1 option: 1", "2 option: 2", "3 option: 0"),  1));
//        questions.add(new Question("Question 10 - Theme: Arithmetic equations tests: x + 2 = ?; if x = 5", Arrays.asList("1 option: 7", "2 option: 5", "3 option: 2"),  1));
//        questions.add(new Question("Question 11 - Theme: Arithmetic equations tests: x - 2 = ?; if x = 10", Arrays.asList("1 option: 7", "2 option: 5", "3 option: 10"),  3));
//        questions.add(new Question("Question 12 - Theme: Arithmetic equations tests: x * 2 = ?; if x = 2", Arrays.asList("1 option: 1", "2 option: 4", "3 option: 3"),  1));
//        questions.add(new Question("Question 13 - Theme: Chemical formulas: What is the formula for nitrogen", Arrays.asList("1 option: N2", "2 option: N3", "3 option: N5"),  1));
//        questions.add(new Question("Question 14 - Theme: Chemical formulas: What is the formula for oxygen?", Arrays.asList("1 option: O", "2 option: O2", "3 option: O3"),  2));
//        questions.add(new Question("Question 15 - Theme: Chemical formulas: What is the formula for hydrogen?", Arrays.asList("1 option: H", "2 option: H2", "3 option: H4"),  2));
//        questions.add(new Question("Question 16 - Theme: Chemical formulas: What is the formula for water?", Arrays.asList("1 option: HO", "2 option: HO2", "3 option: H2O"),  3));
//        questions.add(new Question("Question 17 - Theme: Valence of chemical elements: Determine the valence of chlorine (Cl) in chlorine oxide (Cl2O)", Arrays.asList("1 option: 7", "2 option: 2", "3 option: 3"),  1));
//        questions.add(new Question("Question 18 - Theme: Valence of chemical elements: Determine the valence of Mg in its compound with oxygen (MgO2)", Arrays.asList("1 option: 5", "2 option: 2", "3 option: 3"),  2));
//        questions.add(new Question("Question 19 - Theme: Molecular weight: Determine the relative molecular weight of water (H2 O)", Arrays.asList("1 option: 18", "2 option: 25", "3 option: 21"),  1));
//        questions.add(new Question("Question 20 - Theme: Molecular weight: Determine the relative molecular weight of manganese (Mn)", Arrays.asList("1 option: 55", "2 option: 51", "3 option: 54"),  3));
//        questions.add(new Question("Question 21 - Theme: Molecular weight: Determine the relative molecular weight of magnesium (Mg)", Arrays.asList("1 option: 22", "2 option: 24", "3 option: 30"),  2));
//
//    }



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
