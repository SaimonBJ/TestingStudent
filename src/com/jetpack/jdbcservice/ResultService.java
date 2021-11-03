package com.jetpack.jdbcservice;

import com.jetpack.jdbcdao.JDBCConnection;
import com.jetpack.model.Result;
import com.jetpack.model.Teacher;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static com.jetpack.Collections.*;

/**
 * Reading results data from the database and writing data to collections
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class ResultService extends JDBCConnection{

    /**Connecting to a database*/
    static Connection connection = connectDB();

    /**
     * Method to connect to the database and writing results data to collections
     * @throws SQLException - error when the database connection fails
     */
    public static void getAllResults() throws SQLException {

        /**Querying the database and retrieving results information*/
        String sql = "SELECT result_id, student_id, student_group_id, teacher_id, result, test_id, key, value FROM results, result_map WHERE result_id = id_result";
        /**Querying the database and retrieving teachers information*/
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
