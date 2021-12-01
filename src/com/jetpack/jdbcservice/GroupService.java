package com.jetpack.jdbcservice;

import com.jetpack.jdbc.JDBCConnection;
import com.jetpack.model.Group;
import com.jetpack.model.Student;
import com.jetpack.model.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import static com.jetpack.Collections.addGroup;

/**
 * Reading groups data from the database and writing data to collections
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class GroupService extends JDBCConnection {

    /**Connecting to a database*/
    static Connection connection = connectDB();

    /**
     * Method to connect to the database and writing groups data to collections
     * @throws SQLException - error when the database connection fails
     */
    public static void getAllGroups() throws SQLException {

        /**Querying the database and retrieving groups information*/
        String sql = "SELECT id_group, group_name FROM groups";
        /**Querying the database and retrieving students information*/
        String sqlStudent = "SELECT name_student, students_group FROM students";
        /**Querying the database and retrieving teachers information*/
        String sqlTeacher = "SELECT name_teacher, id_teacher FROM teachers";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            //Add students name
            ResultSet resultSetStudent = statement.executeQuery(sqlStudent);
            HashMap<Integer, ArrayList<Student>> mapStudent = new HashMap<>();
            while (resultSetStudent.next()){
                Student student = new Student();
                ArrayList<Student> list = new ArrayList<>();
                list.add(student);
                student.setName(resultSetStudent.getString("name_student"));
                if (mapStudent.get(resultSetStudent.getInt("students_group")) == null){
                    mapStudent.put(resultSetStudent.getInt("students_group"), list);
                }
                else {
                    mapStudent.get(resultSetStudent.getInt("students_group")).add(student);
                }
            }
            //Add teachers name
            ResultSet resultSetTeacher = statement.executeQuery(sqlTeacher);
            HashMap<Integer, ArrayList<Teacher>> mapTeacher = new HashMap<>();
            while (resultSetTeacher.next()){
                Teacher teacher = new Teacher();
                ArrayList<Teacher> list = new ArrayList<>();
                list.add(teacher);
                teacher.setName(resultSetTeacher.getString("name_teacher"));
                if (mapTeacher.get(resultSetTeacher.getInt("id_teacher")) == null){
                    mapTeacher.put(resultSetTeacher.getInt("id_teacher"), list);
                }
                else {
                    mapTeacher.get(resultSetTeacher.getInt("id_teacher")).add(teacher);
                }
            }
            //Add result data
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Group group = new Group();
                group.setId(resultSet.getInt("id_group"));
                group.setGroupName(resultSet.getString("group_name"));
                group.setStudents(mapStudent.get(group.getId()));
                group.setTeachers(mapTeacher.get(group.getId()));

                addGroup(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null){
                statement.close();
            }
            if (connection !=null){
                connection.close();
            }
        }
    }
}
