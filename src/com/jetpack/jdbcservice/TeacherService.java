package com.jetpack.jdbcservice;

import com.jetpack.jdbcdao.JDBCConnection;
import com.jetpack.model.Student;
import com.jetpack.model.Teacher;
import com.jetpack.model.Tests;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import static com.jetpack.Collections.addTeacher;

/**
 * Reading teachers data from the database and writing data to collections
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class TeacherService extends JDBCConnection {

    /**Connecting to a database*/
    static Connection connection = connectDB();

    /**
     * Method to connect to the database and writing teachers data to collections
     * @throws SQLException - error when the database connection fails
     */
    public static void getAllTeachers() throws SQLException {

        /**Querying the database and retrieving teachers information*/
        String sql = "SELECT id_teacher, name_teacher, subject FROM teachers";
        /**Querying the database and retrieving tests information*/
        String sqlTest = "SELECT test_name, teacher_id from tests";
        /**Querying the database and retrieving students information*/
        String sqlStudent = "SELECT name_student, students_group FROM students";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            //Add tests name
            ResultSet resultSetTest = statement.executeQuery(sqlTest);
            HashMap<Integer, ArrayList<Tests>> mapTest = new HashMap<>();
            while (resultSetTest.next()){
                Tests tests = new Tests();
                ArrayList<Tests> list = new ArrayList<>();
                list.add(tests);
                tests.setTestName(resultSetTest.getString("test_name"));
                if (mapTest.get(resultSetTest.getInt("teacher_id")) == null){
                    mapTest.put(resultSetTest.getInt("teacher_id"), list);
                }
                else {
                    mapTest.get(resultSetTest.getInt("teacher_id")).add(tests);
                }
            }
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
            //Add teachers data
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("id_teacher"));
                teacher.setName(resultSet.getString("name_teacher"));
                teacher.setSubject(resultSet.getString("subject"));
                teacher.setTestName(mapTest.get(teacher.getId()));
                teacher.setStudents(mapStudent.get(teacher.getId()));
                addTeacher(teacher);
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
