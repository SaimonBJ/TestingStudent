package com.JetPack.JDBCDAO;

import java.sql.*;

public class JDBCConnection {

    private final static String url = "jdbc:postgresql://127.0.0.1:5432/trainingCenter";
    private final static String name = "postgres";
    private final static String password = "Semjon.90";
    private static Connection connection = null;
    
    public static Connection connectDB(){

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver is connected");
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Connection established");

        } catch (SQLException | ClassNotFoundException e) {
            e.fillInStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }
    }


