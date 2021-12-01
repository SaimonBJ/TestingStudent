package com.jetpack.jdbc;


import java.sql.*;

/**
 * Connection and authorization in PostgreSQL
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class JDBCConnection {

    /**Url data base*/
    private final static String url = "jdbc:postgresql://127.0.0.1:5432/trainingCenter";
    /**Username*/
    private final static String name = "postgres";
    /**Password to enter*/
    private final static String password = "Semjon.90";
    /**Connection*/
    private static Connection connection = null;

    /**
     * Method to connect to the database and close when finished
     * @throws SQLException - error when the database connection fails
     * @throws ClassNotFoundException - error when loading a class
     */
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


