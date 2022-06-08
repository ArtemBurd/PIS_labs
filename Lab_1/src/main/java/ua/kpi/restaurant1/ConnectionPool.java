package ua.kpi.restaurant1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionPool {
    private static final String url = "jdbc:mysql://localhost:3306/restaurant";
    private static final String username = "root";
    private static final String password = "meow228";

    public ConnectionPool() {

    }

    private static ConnectionPool instance = new ConnectionPool();

    public static ConnectionPool getInstance(){
        return instance;
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
