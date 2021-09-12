package com.JetPack.Model;

import java.util.Arrays;

public class Question {

    private String question;
    private int rightAnswerNumber;
    private String[] answers;

    public Question(String question, String[] answers, int rightAnswerNumber) {
        this.question = question;
        this.rightAnswerNumber = rightAnswerNumber;
        this.answers = answers;
    }

    public int getRightAnswerNumber() {
        return rightAnswerNumber;
    }

    public void setRightAnswerNumber(byte rightAnswerNumber) {
        this.rightAnswerNumber = rightAnswerNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return question +
                "\nAnswer options: " + Arrays.toString(answers);
    }
}
