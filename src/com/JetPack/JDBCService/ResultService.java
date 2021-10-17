package com.JetPack.JDBCService;

import com.JetPack.JDBCDAO.JDBCConnection;
import com.JetPack.Model.Result;
import com.JetPack.Model.Teacher;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static com.JetPack.DataBase.*;

public class ResultService extends JDBCConnection{

    static Connection connection = connectDB();


    public static void getAllResults() throws SQLException {

        String sql = "SELECT result_id, student_id, student_group_id, teacher_id, result, test_id, key, value FROM results, result_map WHERE result_id = id_result";
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
            //Add result data
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Result result = new Result();
                Map<String, Integer> resultMapDB = new HashMap<>();
                result.setResultId(resultSet.getInt("result_id"));
                result.setStudentsId(resultSet.getInt("student_id"));
                result.setTeacherId(resultSet.getInt("student_group_id"));
                result.setStudentsGroupId(resultSet.getInt("teacher_id"));
                result.setTeacherName(mapTeacher.get(result.getTeacherId()));
                result.setResult(resultSet.getInt("result"));
                result.setTestId(resultSet.getInt("test_id"));
                resultMapDB.put(resultSet.getString("key"), resultSet.getInt("value"));
                result.setResultMap(resultMapDB);

                addResult(result);
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
