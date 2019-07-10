package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcLab";
    private static final String USER = "root";
    private static final String PASS = "password";


    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e){
            throw new RuntimeException("Error connecting", e);
        }
    }



}
