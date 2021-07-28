package com.training.model;

import java.util.ArrayList;

public class Result {
    private int resultId;
    private int studentsId;
    private int teacherId;
    private ArrayList<Teacher> teacherName;
    private int testId;
    private int result;


    public Result(int resultId, int studentsId, int teacherId, ArrayList<Teacher> teacherName, int testId, int result) {
        this.resultId = resultId;
        this.studentsId = studentsId;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.testId = testId;
        this.result = result;
    }



    public ArrayList<Teacher> getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(ArrayList<Teacher> teacherName) {
        this.teacherName = teacherName;
    }


    public int getResultId() {
        return resultId;
    }

    public int getStudentsId() {
        return studentsId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getTestId() {
        return testId;
    }

    public int getResult() {
        return result;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public void setStudentsId(int studentsId) {
        this.studentsId = studentsId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public void setResult(int result) {
        this.result = result;
    }
    public int toInt(){
        return getResult();
    }
}
