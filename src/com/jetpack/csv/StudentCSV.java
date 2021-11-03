package com.jetpack.csv;

import com.jetpack.model.Student;
import com.jetpack.model.Tests;
import java.io.*;
import java.util.ArrayList;
import static com.jetpack.Collections.addStudent;

/**
 * A class for reading and writing students files
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class StudentCSV {
    /**Created file name*/
    File StudentListDAO = new File("CSVFiles");
    /**Path to file*/
    private static final String PATH = "CSVFiles\\StudentListDAO.csv";
    /**Variable for data communication*/
    private static final String COMMA_DELIMITER = ",";
    /**Switching to a new line*/
    private static final String NEW_LINE_SEPARATOR = "\n";
    /**Reader*/
    private static BufferedReader bufferedReader;

    /**
     * Method for writing file from collections
     * @param students - collection students
     * @param tests - collection tests
     * @throws IOException - error when writing a file, if the file is not found
     */
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

    /**
     * Method for reading data from file
     * @throws IOException - error when reading a file, if the file is not found
     */
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
