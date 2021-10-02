package com.JetPack.CSV;

import com.JetPack.DataBase;
import com.JetPack.Model.Group;
import com.JetPack.Model.Student;
import com.JetPack.Model.Teacher;

import java.io.*;
import java.util.ArrayList;

import static com.JetPack.DataBase.addGroup;

public class GroupCSV {
    File GroupListDAO = new File("CSVFiles");
    private static final String PATH = "CSVFiles\\GroupListDAO.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static BufferedReader bufferedReader;

    public static void writerFileGroup(ArrayList<Group> groups,  ArrayList<Student> students,  ArrayList<Teacher> teachers){

        try {
            FileWriter fileWriter = new FileWriter(PATH);

            for (Group group : groups){
                fileWriter.append(String.valueOf(group.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(group.getGroupName()));
                fileWriter.append(COMMA_DELIMITER);

                for (Student student : students){
                    if (group.getId() == student.getStudentsGroup()){
                        fileWriter.append(String.valueOf(student.getName()));
                        fileWriter.append(COMMA_DELIMITER);
                    }
                }
                for (Teacher teacher : teachers){
                    if (group.getId() == teacher.getId()){
                        fileWriter.append(String.valueOf(teacher.getName()));
                    }
                }
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFileGroup(){

        String line = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));

            while ((line = bufferedReader.readLine()) != null){
                String[] values = line.split(COMMA_DELIMITER);
                Group group = new Group(values);
                addGroup(group);
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
