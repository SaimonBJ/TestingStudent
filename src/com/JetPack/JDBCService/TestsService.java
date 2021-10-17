package com.JetPack.JDBCService;

import com.JetPack.JDBCDAO.JDBCConnection;
import com.JetPack.Model.Teacher;
import com.JetPack.Model.Tests;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import static com.JetPack.DataBase.addTest;

public class TestsService extends JDBCConnection {

    static Connection connection = connectDB();

    public static void getAllTests() throws SQLException {

        String sql = "SELECT test_id, teacher_id, test_name, number_of_questions FROM tests";
        String sqlTeacher = "SELECT id_teacher, name_teacher, subject FROM teachers";
        Statement statement = null;

        try {
            statement = connection.createStatement();
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
            //Add test data
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Tests test = new Tests();
                test.setTestId(resultSet.getInt("test_id"));
                test.setTeacherId(resultSet.getInt("teacher_id"));
                test.setTeacherName(mapTeacher.get(test.getTeacherId()));
                test.setTestName(resultSet.getString("test_name"));
                test.setNumberOfQuestions(resultSet.getInt("number_of_questions"));

                addTest(test);
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
