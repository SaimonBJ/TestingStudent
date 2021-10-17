package com.JetPack.JDBCService;

import com.JetPack.JDBCDAO.JDBCConnection;
import com.JetPack.Model.Group;
import com.JetPack.Model.Student;
import com.JetPack.Model.Teacher;
import com.JetPack.Model.Tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import static com.JetPack.DataBase.addGroup;

public class GroupService extends JDBCConnection {

    static Connection connection = connectDB();

    public static void getAllGroups() throws SQLException {

        String sql = "SELECT id_group, group_name FROM groups";
        String sqlStudent = "SELECT name_student, students_group FROM students";
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
