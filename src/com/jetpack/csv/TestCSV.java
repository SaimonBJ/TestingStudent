package com.jetpack.csv;

import com.jetpack.model.Teacher;
import com.jetpack.model.Tests;
import java.io.*;
import java.util.ArrayList;
import static com.jetpack.Collections.addTest;

/**
 * A class for reading and writing test files
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class TestCSV {
    /**Created file name*/
    File TestListDAO = new File("CSVFiles");
    /**Path to file*/
    private static final String PATH = "CSVFiles\\TestListDAO.csv";
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
     * @throws IOException - error when writing a file, if the file is not found
     */
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

    /**
     * Method for reading data from file
     * @throws IOException - error when reading a file, if the file is not found
     */
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
