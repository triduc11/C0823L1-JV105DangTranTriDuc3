package repository;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ConnectDB {
    private final static String URL = "jdbc:mysql://localhost:3306/product";
    private final static String USER = "root";
    private final static String PASS = "";
    public static Connection getConnectDB() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
