package com.JetPack.JDBCService;

import com.JetPack.JDBCDAO.JDBCConnection;
import com.JetPack.Model.Question;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static com.JetPack.DataBase.addQuestion;


public class QuestionService extends JDBCConnection {

    static Connection connection = connectDB();

    public static void getAllQuestions() throws SQLException {

        String sql = "SELECT question, right_answer_number, answer, question_id FROM questions, answers WHERE id_question = question_id";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            //Add questions
            ResultSet resultSet = statement.executeQuery(sql);
            HashMap<Integer, Question> questionMap = new HashMap<>();
            while (resultSet.next()){
                if(questionMap.get(resultSet.getInt("question_id")) == null){
                    Question question = new Question();
                    question.setQuestion(resultSet.getString("question"));
                    question.setRightAnswerNumber(resultSet.getInt("right_answer_number"));
                    List<String> answers = new ArrayList();
                    answers.add(resultSet.getString("answer"));
                    question.setAnswers(answers);
                    questionMap.put(resultSet.getInt("question_id"), question);

                }
                else {
                    questionMap.get(resultSet.getInt("question_id")).getAnswers().add(resultSet.getString("answer"));
                }
            }
            //Sorting questions
            ArrayList<Integer> sortedKeys = new ArrayList<>(questionMap.keySet());
            Collections.sort(sortedKeys);
            for (Integer x : sortedKeys){
                addQuestion(questionMap.get(x));
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
