package com.JetPack.CSV;





import com.JetPack.Model.Student;
import com.JetPack.Model.Tests;
import java.io.*;
import java.util.ArrayList;


import static com.JetPack.DataBase.addStudent;


public class StudentCSV {
    File StudentListDAO = new File("CSVFiles");
    private static final String PATH = "CSVFiles\\StudentListDAO.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static BufferedReader bufferedReader;

    public static void writerFileStudent(ArrayList<Student> students, ArrayList<Tests> tests){

        try {
            FileWriter fileWriter = new FileWriter(PATH);
            for (Student student : students){
                fileWriter.append(String.valueOf(student.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(student.getName());
                fileWriter.append(COMMA_DELIMITER);
                for (Tests test : tests){
                    fileWriter.append(String.valueOf(test.getTestName()));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(test.getNumberOfQuestions()));
                    fileWriter.append(COMMA_DELIMITER);
                }
                fileWriter.append(String.valueOf(student.getStudentsGroup()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileStudent(){

        String line = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));

            while ((line = bufferedReader.readLine()) != null){
                String[] values = line.split(COMMA_DELIMITER);
                    Student student = new Student(values);
                    addStudent(student);
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
}
