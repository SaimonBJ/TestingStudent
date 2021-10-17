package com.JetPack.JDBCService;

import com.JetPack.JDBCDAO.JDBCConnection;
import com.JetPack.Model.Admin;
import com.JetPack.Model.Student;
import com.JetPack.Model.Teacher;
import com.JetPack.Model.Tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.JetPack.DataBase.addAdmin;

public class AdminService extends JDBCConnection {

   static  Connection connection = connectDB();

   public static void getAllAdmin() throws SQLException {

        String sql = "SELECT id_admin, name_admin FROM admin";
        String sqlStudent = "SELECT name_student FROM students";
        String sqlTeacher = "SELECT name_teacher FROM teachers";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            //Add students name
            ResultSet resultSetStudent = statement.executeQuery(sqlStudent);
            ArrayList<Student> studentName = new ArrayList<>();
            while (resultSetStudent.next()){
                Student student = new Student();
                student.setName(resultSetStudent.getString("name_student"));
                studentName.add(student);
            }
            //Add teachers name
            ResultSet resultSetTeacher = statement.executeQuery(sqlTeacher);
            ArrayList<Teacher> teacherName = new ArrayList<>();
            while (resultSetTeacher.next()){
                Teacher teacher = new Teacher();
                teacher.setName(resultSetTeacher.getString("name_teacher"));
                teacherName.add(teacher);
            }
            //Add groups data
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Admin admin = new Admin();
                admin.setId(resultSet.getInt("id_admin"));
                admin.setName(resultSet.getString("name_admin"));
                admin.setStudents(studentName);
                admin.setTeachers(teacherName);
                addAdmin(admin);
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
