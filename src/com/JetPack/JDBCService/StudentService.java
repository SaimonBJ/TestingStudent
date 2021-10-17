package com.JetPack.JDBCService;

import com.JetPack.JDBCDAO.JDBCConnection;
import com.JetPack.Model.Student;
import com.JetPack.Model.Tests;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import static com.JetPack.DataBase.addStudent;


public class StudentService extends JDBCConnection {

    static Connection connection = connectDB();

    public static void getAllStudents() throws SQLException {

        String sql = "SELECT id_student, name_student, students_group FROM students";
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
