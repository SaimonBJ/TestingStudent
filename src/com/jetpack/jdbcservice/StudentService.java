package com.jetpack.jdbcservice;

import com.jetpack.jdbc.JDBCConnection;
import com.jetpack.model.Student;
import com.jetpack.model.Tests;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static com.jetpack.Collections.addStudent;

/**
 * Reading students data from the database and writing data to collections
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class StudentService extends JDBCConnection {

    /**Connecting to a database*/
    static Connection connection = connectDB();

    /**
     * Method to connect to the database and writing students data to collections
     * @throws SQLException - error when the database connection fails
     */
    public static void getAllStudents() throws SQLException {

        /**Querying the database and retrieving students information*/
        String sql = "SELECT id_student, name_student, students_group FROM students";
        /**Querying the database and retrieving tests information*/
        String sqlTest = "SELECT test_name FROM tests";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            //Add tests name
            ResultSet resultSetTest = statement.executeQuery(sqlTest);
            ArrayList<Tests> testsName = new ArrayList<>();
            while (resultSetTest.next()){
                Tests tests = new Tests();
                tests.setTestName(resultSetTest.getString("test_name"));
                testsName.add(tests);
            }
            //Add students data
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id_student"));
                student.setName(resultSet.getString("name_student"));
                student.setStudentsGroup(resultSet.getInt("students_group"));
                student.setTestName(testsName);
                addStudent(student);
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
