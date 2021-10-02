package com.JetPack.CSV;

import com.JetPack.DataBase;
import com.JetPack.Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.JetPack.CSV.GroupCSV.readFileGroup;
import static com.JetPack.CSV.GroupCSV.writerFileGroup;
import static com.JetPack.CSV.QuestionCSV.readFileQuestion;
import static com.JetPack.CSV.QuestionCSV.writerFileQuestion;
import static com.JetPack.CSV.ResultCSV.readFileResult;
import static com.JetPack.CSV.ResultCSV.writerFileResult;
import static com.JetPack.CSV.StudentCSV.readFileStudent;
import static com.JetPack.CSV.StudentCSV.writerFileStudent;
import static com.JetPack.CSV.TeacherCSV.readFileTeacher;
import static com.JetPack.CSV.TeacherCSV.writerFileTeacher;
import static com.JetPack.CSV.TestCSV.readFileTest;
import static com.JetPack.CSV.TestCSV.writerFileTest;
import static com.JetPack.DataBase.*;


public class AdminCSV {


    File AdminListDAO = new File("CSVFiles");
    private static final String PATH = "CSVFiles\\AdminListDAO.csv";
    private static final String COMMA_DELIMITER = ",";
    private static BufferedReader bufferedReader;



    public static void writerFileAdmin(ArrayList<Admin> admins){
        ArrayList<Student> students = DataBase.getStudents();
        ArrayList<Teacher> teachers = DataBase.getTeachers();



        try {
            FileWriter fileWriter = new FileWriter(PATH);

            for (Admin admin : admins){
                fileWriter.append(String.valueOf(admin.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(admin.getName());
                fileWriter.append(COMMA_DELIMITER);
                for (Teacher teacher : teachers){
                    fileWriter.append(String.valueOf(teacher.getName()));
                    fileWriter.append(COMMA_DELIMITER);
                }
                for (Student student : students){
                    fileWriter.append(String.valueOf(student.getName()));
                    fileWriter.append(COMMA_DELIMITER);
                }
            }
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void readFileAdmin(){

        String line = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));

            while ((line = bufferedReader.readLine()) != null){
                String[] values = line.split(COMMA_DELIMITER);
                Admin admin = new Admin(values);
                addAdmin(admin);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void serializationAll(){
        //Add all collections to one file
        ArrayList<Admin> admins = DataBase.getAdmins();
        ArrayList<Student> students = DataBase.getStudents();
        ArrayList<Teacher> teachers = DataBase.getTeachers();
        ArrayList<Tests> tests = DataBase.getTests();
        ArrayList<Question> questions = DataBase.getQuestions();
        ArrayList<Result> results = DataBase.getResults();
        ArrayList<Group> groups = DataBase.getGroups();


        try {
            FileOutputStream outputStream = new FileOutputStream("CSVFiles\\SerializableFile.csv");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(admins);
            objectOutputStream.writeObject(students);
            objectOutputStream.writeObject(teachers);
            objectOutputStream.writeObject(tests);
            objectOutputStream.writeObject(questions);
            objectOutputStream.writeObject(results);
            objectOutputStream.writeObject(groups);
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void deSerializationAll(){
        //Reading a common file in a collection
        try {
            FileInputStream fileInputStream = new FileInputStream("CSVFiles\\SerializableFile.csv");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            try {
                ArrayList<Admin> admins = (ArrayList<Admin>) objectInputStream.readObject();
                ArrayList<Student> students = (ArrayList<Student>) objectInputStream.readObject();
                ArrayList<Teacher> teachers = (ArrayList<Teacher>) objectInputStream.readObject();
                ArrayList<Tests> tests = (ArrayList<Tests>) objectInputStream.readObject();
                ArrayList<Question> questions = (ArrayList<Question>) objectInputStream.readObject();
                ArrayList<Result> results = (ArrayList<Result>) objectInputStream.readObject();
                ArrayList<Group> groups = (ArrayList<Group>) objectInputStream.readObject();



                writerFileQuestion(questions);
                writerFileAdmin(admins);
                writerFileGroup(groups, students, teachers);
                writerFileResult(results, teachers);
                writerFileStudent(students, tests);
                writerFileTeacher(teachers, tests, results);
                writerFileTest(tests, teachers);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            } catch (IOException e) {
            e.printStackTrace();
            }


    }


    public static void deleteFiles(){
        //Deleting the contents of all files
        List<String> allFiles = new ArrayList<>();
        Collections.addAll(allFiles, "CSVFiles\\GroupListDAO.csv", "CSVFiles\\QuestionListDAO.csv",
                "CSVFiles\\ResultListDAO.csv", "CSVFiles\\StudentListDAO.csv",
                "CSVFiles\\TeacherListDAO.csv", "CSVFiles\\TestListDAO.csv");

        try {
            for (String deleteFile : allFiles) {
                FileWriter fileWriter = new FileWriter(deleteFile);
                fileWriter.write("");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
