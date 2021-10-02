package com.JetPack.CSV;

import com.JetPack.DataBase;
import com.JetPack.Model.Result;
import com.JetPack.Model.Teacher;

import java.io.*;
import java.util.ArrayList;

import static com.JetPack.DataBase.addResult;

public class ResultCSV {
    File ResultListDAO = new File("CSVFiles");
    private static final String PATH = "CSVFiles\\ResultListDAO.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static BufferedReader bufferedReader;

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
