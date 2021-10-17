package com.JetPack.Model;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    private String question;
    private int rightAnswerNumber;
    private List<String> answers;


    public Question(String question, List<String> answers, int rightAnswerNumber) {
        this.question = question;
        this.rightAnswerNumber = rightAnswerNumber;
        this.answers = answers;
    }

    public Question(String[] value) {
        this.question = value[0];
        fillQuestionFromStringValues(value);
        this.rightAnswerNumber = Integer.parseInt(value[4]);

    }

    public Question() {

    }

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
