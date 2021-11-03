package com.jetpack.csv;

import com.jetpack.Collections;
import com.jetpack.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.jetpack.csv.GroupCSV.writerFileGroup;
import static com.jetpack.csv.QuestionCSV.writerFileQuestion;
import static com.jetpack.csv.ResultCSV.writerFileResult;
import static com.jetpack.csv.StudentCSV.writerFileStudent;
import static com.jetpack.csv.TeacherCSV.writerFileTeacher;
import static com.jetpack.csv.TestCSV.writerFileTest;
import static com.jetpack.Collections.*;

/**
 * A class for reading and writing admin files, serializing and deserializing all user files
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class AdminCSV {

    /**Created file name*/
    File AdminListDAO = new File("CSVFiles");
    /**Path to file*/
    private static final String PATH = "CSVFiles\\AdminListDAO.csv";
    /**Variable for data communication*/
    private static final String COMMA_DELIMITER = ",";
    /**Reader*/
    private static BufferedReader bufferedReader;

    /**
     * Method for writing file from collections
     * @param admins - collection administrator
     * @throws IOException - error when writing a file, if the file is not found
     */
    public static void writerFileAdmin(ArrayList<Admin> admins){
        ArrayList<Student> students = Collections.getStudents();
        ArrayList<Teacher> teachers = Collections.getTeachers();

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

    /**
     * Method for reading data from file
     * @throws IOException - error when reading a file, if the file is not found
     */
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

    /**
     * Method for serializing all data into one file
     * @throws IOException - serialization error, if the files is not found
     */
    public static void serializationAll(){
        //Add all collections to one file
        ArrayList<Admin> admins = Collections.getAdmins();
        ArrayList<Student> students = Collections.getStudents();
        ArrayList<Teacher> teachers = Collections.getTeachers();
        ArrayList<Tests> tests = Collections.getTests();
        ArrayList<Question> questions = Collections.getQuestions();
        ArrayList<Result> results = Collections.getResults();
        ArrayList<Group> groups = Collections.getGroups();


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

    /**
     * Method for deserializing all data into files
     * @throws IOException - deserialization error, if the file is not found
     */
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


    /**
     * Method to delete all files
     * @throws IOException - delete error, if the files is not found
     */
    public static void deleteFiles(){
        //Deleting the contents of all files
        List<String> allFiles = new ArrayList<>();
        java.util.Collections.addAll(allFiles, "CSVFiles\\GroupListDAO.csv", "CSVFiles\\QuestionListDAO.csv",
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
