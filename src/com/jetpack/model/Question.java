package com.jetpack.model;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Class question
 *
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class Question implements Serializable {
    /**Unique indicator for serializable class*/
    private static final long serialVersionUID = 1L;
    /**Question name*/
    private String question;
    /**Right answer number*/
    private int rightAnswerNumber;
    /**Answers from test*/
    private List<String> answers;

    /**
     * Constructor for create question collection
     * @param question - question name
     * @param rightAnswerNumber - right answer number
     * @param answers - answers from test
     * */
    public Question(String question, List<String> answers, int rightAnswerNumber) {
        this.question = question;
        this.rightAnswerNumber = rightAnswerNumber;
        this.answers = answers;
    }

    /**
     * Constructor for create question collection from files
     * @param value - data from the file passed into the array
     * */
    public Question(String[] value) {
        this.question = value[0];
        fillQuestionFromStringValues(value);
        this.rightAnswerNumber = Integer.parseInt(value[4]);

    }

    /**Empty constructor*/
    public Question() {

    }

    /**
     * Method for reading answers data from a file into the question collection
     * @param value - data from the file passed into the array
     * */
    public void fillQuestionFromStringValues(String[] value){
        //Reading question data into a collection from a file
        for (int i = 1; i < value.length-1; i+=3){
            answers = List.of(value[i],value[i+1], value[i+2]);
        }
    }

    public int getRightAnswerNumber() {
        return rightAnswerNumber;
    }

    public void setRightAnswerNumber(int rightAnswerNumber) {
        this.rightAnswerNumber = rightAnswerNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "\n" + question +
                "\nAnswers options: " + Arrays.toString(new List[]{answers});
    }
}
