package com.training;

import com.training.model.*;

import java.util.*;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Tests> tests = new ArrayList<>();
    static ArrayList<Result> results = new ArrayList<>();
    static ArrayList<Group> groups = new ArrayList<>();
    static ArrayList<Question> questions = new ArrayList<>();









    public static void main(String[] args) {

        initData();
        viewDataBase();



    }


    //View DataBase
    public static void viewDataBase(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your position in the training center: Student, Teacher or Admin");
        String positionInCenter = scan.nextLine();

        switch (positionInCenter) {
            case ("Student"):
                getStudentData();
                break;

            case ("Teacher"):
                getTeacherData();
                break;

            case ("Admin"):
                getAdminData();
                break;

            default:
                System.out.println("Error: there is no user data in the database!");

        }
    }




    //View profile User Student
    public static void getStudentData(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String st1 = scan.nextLine();
        for (Student st : students){
            if (st.getName().equals(st1)){
                System.out.println("Student " + st1 + " has a list of tests:");
                for (int i = 0; i < st.getTestName().size(); i++) {
                    System.out.println(i + 1 + ". " + st.getTestName().get(i).getTestName() + " ,number of questions on the test - " + st.getNumberOfQuestions().get(i).getNumberOfQuestions());
                }
            }
            getStartTestQuestions();
        }

    }


    //View profile User Teacher
    public static void getTeacherData(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String tch1 = scan.nextLine();
        for (Teacher teacher : teachers) {
            if (teacher.getName().equals(tch1)) {
                System.out.println("Teacher Test List " + tch1 + ":");
                for (int j = 0; j < tests.size(); j++) {
                    if (tests.get(j).getTeacherId() == teacher.getId()) {
                        System.out.println(j + 1 + ". " + tests.get(j).getTestName());
                    }


                }
                results.sort(Comparator.comparing(Result::getResult).reversed());
                System.out.println("Students results:");
                for (Result result : results) {
                    if (result.getTeacherId() == teacher.getId()) {
                        System.out.println("In group: " + groups.get(result.getStudentsGroupId() - 1).getGroupName() + ", student -  " + students.get(result.getStudentsId() - 1).getName() + " , rated - " + " - " + result.getResultMap());
                    }

                }


            }


        }
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Choose another teacher - enter Restart\nGo to the main menu? - enter Menu\nIf you want to close the program - press Enter");
        String tch2 = scan2.nextLine();
        if (tch2.equals("Restart")){
            testStart();
        }

        else if (tch2.equals("Menu")){
            viewDataBase();
        }

        else {
            System.out.println("Bye!");
        }
    }

    //View profile User Admin
    public static void getAdminData(){
       for (Admin administrator:admins){
            System.out.println("There are such users in the system ");

            for (int i = 0; i < administrator.getStudents().size(); i++) {

                System.out.println( i + 1 + ".Student " +  administrator.getStudents().get(i).getName());
            }
            for (int i = 0; i < administrator.getTeachers().size(); i++) {

                System.out.println( i + 1 + ".Teacher " +  administrator.getTeachers().get(i).getName());
            }

        }
       Scanner scan = new Scanner(System.in);
       System.out.println("If you want to exit to the main menu - enter Menu\nIf you want to close the program - press Enter");
       String adm = scan.nextLine();
       if (adm.equals("Menu")){
           viewDataBase();
       }


       else {
           System.out.println("Bye!");

       }
    }



    //Test Start
    public static void testStart(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name again: ");
        String st1 = scan.nextLine();
        Scanner sc = new Scanner(System.in);
        int[] rightAnswersCounter = new int[1];
        questions.forEach(question -> {
            System.out.println("Choose one of the three answers, enter 1, 2, or 3 in the console");
            System.out.println(question);
            if (sc.nextByte() == question.getRightAnswerNumber())
                rightAnswersCounter[0]++;

        });

        System.out.println(st1 + " " + "true answers: " + rightAnswersCounter[0]);

        if (rightAnswersCounter[0] < 11){

            System.out.println("The test failed!Your grade F");
        }

        else if (rightAnswersCounter[0] < 16){
            System.out.println("It's better!Your grade С");
        }

        else if (rightAnswersCounter[0] < 20){
            System.out.println("Very good!Your grade B");
        }

        else if (rightAnswersCounter[0] == 21){
            System.out.println("Perfect!Your grade A");
        }

        for (int i = 0; i < results.size(); i++) {
            if (st1.equals(students.get(i).getName())){
                results.get(i).getResultMap().put(students.get(i).getName(), rightAnswersCounter[0]);

            }

        }

        Scanner scan2 = new Scanner(System.in);
        System.out.println("Take the test again? - enter Restart\nGo to the main menu? - enter Menu\nIf you want to close the program - press Enter");
        String st2 = scan2.nextLine();

        if (st2.equals("Restart")){
            testStart();
        }

        else if (st2.equals("Menu")){
            viewDataBase();


        }
        else {
            System.out.println("Bye!");
        }

    }

    public static void getStartTestQuestions() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Students are required to take a test: two subjects - Mathematics and Chemistry\nYes or No");
        String testQ = scanner.nextLine();
        if (testQ.equals("Yes")) {
            testStart();
        }

        else {
            System.out.println("You are not accepted into the training center.");
            viewDataBase();
        }
    }





        public static void initData() {

        //Students
        students.add(new Student(1, "Mike", tests,tests,1));
        students.add(new Student(2, "John",tests,tests,1));
        students.add(new Student(3, "Saimon",tests,tests,1));
        students.add(new Student(4, "Linda",tests,tests,1));
        students.add(new Student(5, "Amanda",tests,tests,1));
        students.add(new Student(6, "Floyd",tests,tests,2));
        students.add(new Student(7, "Stiven",tests,tests,2));
        students.add(new Student(8, "Peter",tests,tests,2));
        students.add(new Student(9, "Elena",tests,tests,2));
        students.add(new Student(10, "Maria",tests,tests,2));

        //Teachers
        teachers.add(new Teacher(1,"Mrs.Jones", "Math", tests, results));
        teachers.add(new Teacher(2,"Mr.Andersen", "Chemistry",tests, results));

        //Admin

        admins.add(new Admin(1,"Mark Zuckerberg",teachers, students));

        //Groups
        groups.add(new Group(1, "Group-001", students, teachers));
        groups.add(new Group(2, "Group-002", students, teachers));

        //Tests
        tests.add(new Tests(1,1,teachers,"Arithmetic tests",5));
        tests.add(new Tests(2,1,teachers,"Elementary Algebra tests",4));
        tests.add(new Tests(3,1,teachers,"Arithmetic equations tests",3));
        tests.add(new Tests(4,2,teachers,"Chemical formulas",4));
        tests.add(new Tests(5,2,teachers,"Valence of chemical elements",2));
        tests.add(new Tests(6,2,teachers,"Molecular weight",3));

        //Test questions

        questions.add(new Question("Question 1, Theme: Arithmetic tests\n2 + 2 = ?", new String[]{"1 option: 2", "2 option: 4", "3 option: 6"}, (byte) 2));
        questions.add(new Question("Question 2, Theme: Arithmetic tests\n2 - 2 = ?", new String[]{"1 option: 0", "2 option: 1", "3 option: 2"}, (byte) 1));
        questions.add(new Question("Question 3, Theme: Arithmetic tests\n2 * 2 = ?", new String[]{"1 option: 2", "2 option: 8", "3 option: 4"}, (byte) 3));
        questions.add(new Question("Question 4, Theme: Arithmetic tests\n2 / 2 = ?", new String[]{"1 option: 1", "2 option: 2", "3 option: 0"}, (byte) 1));
        questions.add(new Question("Question 5, Theme: Arithmetic tests\n2 + 4 = ?", new String[]{"1 option: 6", "2 option: 7", "3 option: 9"}, (byte) 1));
        questions.add(new Question("Question 6, Theme: Elementary Algebra tests\n2 + 2 * 2 = ?", new String[]{"1 option: 10", "2 option: 8", "3 option: 6"}, (byte) 3));
        questions.add(new Question("Question 7, Theme: Elementary Algebra tests\n2 + 2 / 2 = ?", new String[]{"1 option: 3", "2 option: 2", "3 option: 4"}, (byte) 1));
        questions.add(new Question("Question 8, Theme: Elementary Algebra tests\n5 - 2 * 2 = ?", new String[]{"1 option: 1", "2 option: 6", "3 option: 3"}, (byte) 1));
        questions.add(new Question("Question 9, Theme: Elementary Algebra tests\n2 - 2 / 2 = ?", new String[]{"1 option: 1", "2 option: 2", "3 option: 0"}, (byte) 1));
        questions.add(new Question("Question 10, Theme: Arithmetic equations tests\nx + 2 = ?, if x = 5", new String[]{"1 option: 7", "2 option: 5", "3 option: 2"}, (byte) 1));
        questions.add(new Question("Question 11, Theme: Arithmetic equations tests\nx - 2 = ?, if x = 10", new String[]{"1 option: 7", "2 option: 5", "3 option: 10"}, (byte) 3));
        questions.add(new Question("Question 12, Theme: Arithmetic equations tests\nx * 2 = ?, if x = 2", new String[]{"1 option: 1", "2 option: 4", "3 option: 3"}, (byte) 1));
        questions.add(new Question("Question 13, Theme: Chemical formulas\nWhat is the formula for nitrogen", new String[]{"1 option: N2", "2 option: N3", "3 option: N5"}, (byte) 1));
        questions.add(new Question("Question 14, Theme: Chemical formulas\nWhat is the formula for oxygen?", new String[]{"1 option: O", "2 option: O2", "3 option: O3"}, (byte) 2));
        questions.add(new Question("Question 15, Theme: Chemical formulas\nWhat is the formula for hydrogen?", new String[]{"1 option: H", "2 option: H2", "3 option: H4"}, (byte) 2));
        questions.add(new Question("Question 16, Theme: Chemical formulas\nWhat is the formula for water?", new String[]{"1 option: HO", "2 option: HO2", "3 option: H2O"}, (byte) 3));
        questions.add(new Question("Question 17, Theme: Valence of chemical elements\nDetermine the valence of chlorine (Cl) in chlorine oxide (Cl2O)", new String[]{"1 option: 7", "2 option: 2", "3 option: 3"}, (byte) 1));
        questions.add(new Question("Question 18, Theme: Valence of chemical elements\nDetermine the valence of Mg in its compound with oxygen (MgO2)", new String[]{"1 option: 5", "2 option: 2", "3 option: 3"}, (byte) 2));
        questions.add(new Question("Question 19, Theme: Molecular weight\nDetermine the relative molecular weight of water (H2 O)", new String[]{"1 option: 18", "2 option: 25", "3 option: 21"}, (byte) 1));
        questions.add(new Question("Question 20, Theme: Molecular weight\nDetermine the relative molecular weight of manganese (Mn)", new String[]{"1 option: 55", "2 option: 51", "3 option: 54"}, (byte) 3));
        questions.add(new Question("Question 21, Theme: Molecular weight\nDetermine the relative molecular weight of magnesium (Mg)", new String[]{"1 option: 22", "2 option: 24", "3 option: 30"}, (byte) 2));

        //Test results
        results.add(new Result(1,1,1,1,teachers,1,0, new HashMap<>()));
        results.add(new Result(2,2,1,1,teachers,2,0, new HashMap<>()));
        results.add(new Result(3,3,1,1,teachers,3,0, new HashMap<>()));
        results.add(new Result(4,4,1,1,teachers,1,0, new HashMap<>()));
        results.add(new Result(5,5,1,1,teachers,2,0, new HashMap<>()));
        results.add(new Result(6,6,2,2,teachers,4,0, new HashMap<>()));
        results.add(new Result(7,7,2,2,teachers,5,0, new HashMap<>()));
        results.add(new Result(8,8,2,2,teachers,6,0, new HashMap<>()));
        results.add(new Result(9,9,2,2,teachers,4,0, new HashMap<>()));
        results.add(new Result(10,10,2,2,teachers,5,0, new HashMap<>()));

    }



    }







