package com.JetPack.Model;

import java.util.ArrayList;
import java.util.Map;

public class Result implements Comparable <Result> {
    private int resultId;
    private int studentsId;
    private int studentsGroupId;
    private int teacherId;
    private ArrayList<Teacher> teacherName;
    private int testId;
    private int result;
    private Map<String, Integer> resultMap;

    public Result(int resultId, int studentsId, int studentsGroupId, int teacherId, ArrayList<Teacher> teacherName, int testId, int result, Map<String, Integer> resultMap) {
        this.resultId = resultId;
        this.studentsId = studentsId;
        this.studentsGroupId = studentsGroupId;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.testId = testId;
        this.result = result;
        this.resultMap = resultMap;
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

    public int getStudentsGroupId() {
        return studentsGroupId;
    }

    public void setStudentsGroupId(int studentsGroupId) {
        this.studentsGroupId = studentsGroupId;
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

    public Map<String, Integer> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public int compareTo(Result o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Result" +
                "result=" + result;
    }
}
