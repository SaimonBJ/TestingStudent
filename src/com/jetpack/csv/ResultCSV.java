package com.jetpack.csv;

import com.jetpack.model.Result;
import com.jetpack.model.Teacher;
import java.io.*;
import java.util.ArrayList;
import static com.jetpack.Collections.addResult;

/**
 * A class for reading and writing result files
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class ResultCSV {
    /**Created file name*/
    File ResultListDAO = new File("CSVFiles");
    /**Path to file*/
    private static final String PATH = "CSVFiles\\ResultListDAO.csv";
    /**Variable for data communication*/
    private static final String COMMA_DELIMITER = ",";
    /**Switching to a new line*/
    private static final String NEW_LINE_SEPARATOR = "\n";
    /**Reader*/
    private static BufferedReader bufferedReader;

    /**
     * Method for writing file from collections
     * @param results - collection results
     * @param teachers - collection teachers
     * @throws IOException - error when writing a file, if the file is not found
     */
    public static void writerFileResult(ArrayList<Result> results, ArrayList<Teacher> teachers){

        try {
            FileWriter fileWriter = new FileWriter(PATH);
            for (Result result : results){
                fileWriter.append(String.valueOf(result.getResultId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(result.getStudentsId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(result.getStudentsGroupId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(result.getTeacherId()));
                fileWriter.append(COMMA_DELIMITER);
                for (Teacher teacher : teachers){
                    if (result.getTeacherId() == teacher.getId()){
                        fileWriter.append(String.valueOf(teacher.getName()));
                        fileWriter.append(COMMA_DELIMITER);
                    }
                }
                fileWriter.append(String.valueOf(result.getTestId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(result.getResultMap()));
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
    public static void readFileResult(){

        String line = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));

            while ((line = bufferedReader.readLine()) != null){
                String[] values = line.split(COMMA_DELIMITER);
                Result result = new Result(values);
                addResult(result);
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
