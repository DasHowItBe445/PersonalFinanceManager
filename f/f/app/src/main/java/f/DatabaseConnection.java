package f;

import java.sql.*;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://127.0.0.1/test";
    private static final String USER = "dkg";
    private static final String PASS = "hardevdutt709";

    public static Connection get_Connection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASS);
    }

    public static Connection testConnection() {
        Connection conn =null;
        try {
            conn = get_Connection();
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            // System.out.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
    
    
    public static void main(String[] args) {
        testConnection();
    }
}