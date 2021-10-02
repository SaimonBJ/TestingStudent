package com.JetPack.CSV;

import com.JetPack.DataBase;
import com.JetPack.Model.Result;
import com.JetPack.Model.Teacher;
import com.JetPack.Model.Tests;

import java.io.*;
import java.util.ArrayList;

import static com.JetPack.DataBase.addTeacher;

public class TeacherCSV {

    File TeacherListDAO = new File("CSVFiles");
    private static final String PATH = "CSVFiles\\TeacherListDAO.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static BufferedReader bufferedReader;

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
