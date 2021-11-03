package com.jetpack.csv;

import com.jetpack.model.Result;
import com.jetpack.model.Teacher;
import com.jetpack.model.Tests;
import java.io.*;
import java.util.ArrayList;
import static com.jetpack.Collections.addTeacher;

/**
 * A class for reading and writing teachers files
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class TeacherCSV {
    /**Created file name*/
    File TeacherListDAO = new File("CSVFiles");
    /**Path to file*/
    private static final String PATH = "CSVFiles\\TeacherListDAO.csv";
    /**Variable for data communication*/
    private static final String COMMA_DELIMITER = ",";
    /**Switching to a new line*/
    private static final String NEW_LINE_SEPARATOR = "\n";
    /**Reader*/
    private static BufferedReader bufferedReader;

    /**
     * Method for writing file from collections
     * @param teachers - collection teachers
     * @param tests - collection tests
     * @param results - collection results
     * @throws IOException - error when writing a file, if the file is not found
     */
    public static void writerFileTeacher(ArrayList<Teacher> teachers,  ArrayList<Tests> tests, ArrayList<Result> results){

        try {
            FileWriter fileWriter = new FileWriter(PATH);
            for (Teacher teacher : teachers){
                fileWriter.append(String.valueOf(teacher.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(teacher.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(teacher.getSubject()));
                fileWriter.append(COMMA_DELIMITER);
                for (Tests testsList : tests){
                    if (teacher.getId() == testsList.getTeacherId()){
                        fileWriter.append(String.valueOf(testsList.getTestName()));
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(String.valueOf(testsList.getNumberOfQuestions()));
                        fileWriter.append(COMMA_DELIMITER);
                    }
                }
                for (Result result : results){
                    if (result.getTeacherId() == teacher.getId()){
                        fileWriter.append(String.valueOf(result.getResultMap()));
                        fileWriter.append(COMMA_DELIMITER);
                    }
                }
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
    public static void readFileTeacher(){

        String line = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));

            while ((line = bufferedReader.readLine()) != null){
                String[] values = line.split(COMMA_DELIMITER);
                Teacher teacher = new Teacher(values);
                addTeacher(teacher);
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
