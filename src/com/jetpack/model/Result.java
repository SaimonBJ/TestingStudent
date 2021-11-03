package com.jetpack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class result
 *
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */

public class Result implements Comparable <Result> , Serializable {
    /**Unique indicator for serializable class*/
    private static final long serialVersionUID = 1L;
    /**Result id*/
    private int resultId;
    /**Student id*/
    private int studentsId;
    /**Student's group id*/
    private int studentsGroupId;
    /**Teacher id*/
    private int teacherId;
    /**Teacher name from teacher collection*/
    private ArrayList<Teacher> teacherName;
    /**Test id*/
    private int testId;
    /**Result data*/
    private int result;
    /**Result data from map*/
    private Map<String, Integer> resultMap = new HashMap<>();

    /**
     * Constructor for create tests collection
     * @param resultId - result index
     * @param studentsId - student index
     * @param studentsGroupId - student's group index
     * @param teacherId - teacher index
     * @param teacherName - Teacher name from teacher collection
     * @param testId - test index
     * @param result  - result data
     * resultMap - create new Map after test
     * */
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

    /**Empty constructor*/
    public Result() {

    }

    /**
     * Constructor for create result collection from files
     * @param values - data from the file passed into the array
     * */
    public Result(String[] values) {
        this.resultId = Integer.parseInt(values[0]);
        this.studentsId = Integer.parseInt(values[1]);
        this.studentsGroupId = Integer.parseInt(values[2]);
        this.teacherId = Integer.parseInt(values[3]);
        fillTeacherFromStringValues(values);
        this.testId = Integer.parseInt(values[5]);
        splitTestResult(values[6]);
    }

    /**
     * Method for reading teacher data from a file into the result collection
     * @param value - data from the file passed into the array
     * */
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

    /**
     * Method for reading result data from a file into the result collection
     * @param value - data from the file passed into the array
     * */
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

        List<String> nameTeacher = new ArrayList<>();
        for (int i = 0; i < teacherName.size() ; i++) {
            teacherName.get(i).getName();
            nameTeacher.add(teacherName.get(i).getName());
        }

        return "Result{" +
                "resultId=" + resultId +
                ", studentsId=" + studentsId +
                ", studentsGroupId=" + studentsGroupId +
                ", teacherId=" + teacherId +
                ", teacherName=" + nameTeacher +
                ", testId=" + testId +
                ", result=" + result +
                ", resultMap=" + resultMap +
                '}';
    }
}
