package com.JetPack;







import com.JetPack.View.UsersView;

import static com.JetPack.CSV.AdminCSV.readFileAdmin;
import static com.JetPack.CSV.GroupCSV.readFileGroup;
import static com.JetPack.CSV.QuestionCSV.readFileQuestion;
import static com.JetPack.CSV.ResultCSV.readFileResult;
import static com.JetPack.CSV.StudentCSV.readFileStudent;
import static com.JetPack.CSV.TeacherCSV.readFileTeacher;
import static com.JetPack.CSV.TestCSV.readFileTest;


public class Main {

    public static void main(String[] args) {

//        readFileTest();
//        readFileGroup();
//        readFileAdmin();
//        readFileResult();
//        readFileTeacher();
//        readFileStudent();
//        readFileQuestion();
//                serializationAll();
////        deleteFiles();
//        deSerializationAll();

//        writerFileQuestion();
//        writerFileAdmin();
//        writerFileGroup();
//        writerFileResult();
//        writerFileStudent();
//        writerFileTeacher();
//        writerFileTest();
        readFileTest();
        readFileGroup();
        readFileAdmin();
        readFileResult();
        readFileTeacher();
        readFileStudent();
        readFileQuestion();
        UsersView.viewDataBase();
    }


}







