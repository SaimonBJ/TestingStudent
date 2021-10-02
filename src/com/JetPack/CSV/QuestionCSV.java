package com.JetPack.CSV;

import com.JetPack.DataBase;
import com.JetPack.Model.Question;

import java.io.*;
import java.util.ArrayList;

import static com.JetPack.DataBase.addQuestion;

public class QuestionCSV {
    File QuestionListDAO = new File("CSVFiles");
    private static final String PATH = "CSVFiles\\QuestionListDAO.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static BufferedReader bufferedReader;

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
