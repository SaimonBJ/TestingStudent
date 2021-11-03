package com.jetpack.csv;

import com.jetpack.model.Question;
import java.io.*;
import java.util.ArrayList;
import static com.jetpack.Collections.addQuestion;

/**
 * A class for reading and writing question files
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class QuestionCSV {
    /**Created file name*/
    File QuestionListDAO = new File("CSVFiles");
    /**Path to file*/
    private static final String PATH = "CSVFiles\\QuestionListDAO.csv";
    /**Variable for data communication*/
    private static final String COMMA_DELIMITER = ",";
    /**Switching to a new line*/
    private static final String NEW_LINE_SEPARATOR = "\n";
    /**Reader*/
    private static BufferedReader bufferedReader;

    /**
     * Method for writing file from collections
     * @param questions  - collection questions
     * @throws IOException - error when writing a file, if the file is not found
     */
    public static void writerFileQuestion(ArrayList<Question> questions){

        try {
            FileWriter fileWriter = new FileWriter(PATH);
            for (Question question : questions){
                fileWriter.append(String.valueOf(question.getQuestion()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(question.getAnswers()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(question.getRightAnswerNumber()));
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
    public static void readFileQuestion(){

        String line = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));

            while ((line = bufferedReader.readLine()) != null){
                String[] values = line.split(COMMA_DELIMITER);
                Question question = new Question(values);
                addQuestion(question);
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
