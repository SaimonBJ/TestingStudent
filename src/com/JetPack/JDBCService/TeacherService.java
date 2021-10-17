package com.JetPack.JDBCService;

import com.JetPack.JDBCDAO.JDBCConnection;
import com.JetPack.Model.Result;
import com.JetPack.Model.Student;
import com.JetPack.Model.Teacher;
import com.JetPack.Model.Tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static com.JetPack.DataBase.addTeacher;

    public class TeacherService extends JDBCConnection {

    static Connection connection = connectDB();

    public static void getAllTeachers() throws SQLException {

        String sql = "SELECT id_teacher, name_teacher, subject FROM teachers";
        String sqlTest = "SELECT test_name, teacher_id from tests";
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
