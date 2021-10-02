package com.JetPack.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result implements Comparable <Result> , Serializable {
    private static final long serialVersionUID = 1L;
    private int resultId;
    private int studentsId;
    private int studentsGroupId;
    private int teacherId;
    private ArrayList<Teacher> teacherName;
    private int testId;
    private int result;
    private Map<String, Integer> resultMap = new HashMap<>();

    public Result(int resultId, int studentsId, int studentsGroupId, int teacherId, ArrayList<Teacher> teacherName, int testId, int result) {
        this.resultId = resultId;
        this.studentsId = studentsId;
        this.studentsGroupId = studentsGroupId;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.testId = testId;
        this.result = result;
        this.resultMap = new HashMap<>();
    }

    public Result() {

    }

    public Result(String[] values) {
        this.resultId = Integer.parseInt(values[0]);
        this.studentsId = Integer.parseInt(values[1]);
        this.studentsGroupId = Integer.parseInt(values[2]);
        this.teacherId = Integer.parseInt(values[3]);
        fillTeacherFromStringValues(values);
        this.testId = Integer.parseInt(values[5]);
        splitTestResult(values[6]);
    }

    public void fillTeacherFromStringValues(String[] value){
        //Reading teacher data into a result collection from a file
        ArrayList<Teacher> teachersList = new ArrayList<>();
        for (int i = 4; i < value.length-2; i++){
            Teacher teacher = new Teacher();
            teacher.setName(value[i]);
            teachersList.add(teacher);
        }
        this.teacherName = teachersList;
    }

    public void splitTestResult(String value){
        //Add HashMap into a collection from a file
        List<String> lines = List.of(value.split("="));
        if (lines.size() > 1) {
            resultMap.put(lines.get(0), Integer.parseInt(lines.get(1)));
        }
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
