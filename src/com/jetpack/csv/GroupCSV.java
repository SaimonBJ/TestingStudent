package com.jetpack.csv;

import com.jetpack.model.Group;
import com.jetpack.model.Student;
import com.jetpack.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import static com.jetpack.Collections.addGroup;

/**
 * A class for reading and writing group files
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class GroupCSV {
    /**Created file name*/
    File GroupListDAO = new File("CSVFiles");
    /**Path to file*/
    private static final String PATH = "CSVFiles\\GroupListDAO.csv";
    /**Variable for data communication*/
    private static final String COMMA_DELIMITER = ",";
    /**Switching to a new line*/
    private static final String NEW_LINE_SEPARATOR = "\n";
    /**Reader*/
    private static BufferedReader bufferedReader;

    /**
     * Method for writing file from collections
     * @param groups  - collection administrator
     * @param students - collection students
     * @param teachers - collection teachers
     * @throws IOException - error when writing a file, if the file is not found
     */
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

    /**
     * Method for reading data from file
     * @throws IOException - error when reading a file, if the file is not found
     */
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
