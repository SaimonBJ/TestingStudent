package com.JetPack.CSV;

import com.JetPack.DataBase;
import com.JetPack.Model.Teacher;
import com.JetPack.Model.Tests;

import java.io.*;
import java.util.ArrayList;

import static com.JetPack.DataBase.addTest;

public class TestCSV {

    File TestListDAO = new File("CSVFiles");
    private static final String PATH = "CSVFiles\\TestListDAO.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static BufferedReader bufferedReader;

    public static void writerFileTest(ArrayList<Tests> tests, ArrayList<Teacher> teachers){

        try {
            FileWriter fileWriter = new FileWriter(PATH);
            for (Tests test : tests){
                fileWriter.append(String.valueOf(test.getTestId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(test.getTeacherId()));
                fileWriter.append(COMMA_DELIMITER);
                for (Teacher teacher : teachers){
                    if (test.getTeacherId() == teacher.getId()){
                        fileWriter.append(String.valueOf(teacher.getName()));
                        fileWriter.append(COMMA_DELIMITER);
                    }
                }
                fileWriter.append(String.valueOf(test.getTestName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(test.getNumberOfQuestions()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFileTest(){

        String line = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));

            while ((line = bufferedReader.readLine()) != null){
                String[] values = line.split(COMMA_DELIMITER);
                Tests test = new Tests(values);
                addTest(test);
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
