package com.jetpack.jdbcservice;

import com.jetpack.jdbcdao.JDBCConnection;
import com.jetpack.model.Admin;
import com.jetpack.model.Student;
import com.jetpack.model.Teacher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static com.jetpack.Collections.addAdmin;

/**
 * Reading administrator data from the database and writing data to collections
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class AdminService extends JDBCConnection {
    /**Connecting to a database*/
   static  Connection connection = connectDB();

    /**
     * Method to connect to the database and writing administrator data to collections
     * @throws SQLException - error when the database connection fails
     */
   public static void getAllAdmin() throws SQLException {

        /**Querying the database and retrieving admin information*/
        String sql = "SELECT id_admin, name_admin FROM admin";
        /**Querying the database and retrieving students information*/
        String sqlStudent = "SELECT name_student FROM students";
        /**Querying the database and retrieving teachers information*/
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
