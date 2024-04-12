package com.example.thiketthucmd3.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
   private static final String JDBC_URl = "jdbc:mysql://localhost:3306/quan_ly_benh_an";
   private static final String USERNAME = "root";
   private static final String PASSWORD = "123456";

    public BaseRepository() {
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URl,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
