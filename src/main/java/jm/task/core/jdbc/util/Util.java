package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public static Connection getConnection() {
        Connection con;

        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return con;
        } catch (SQLException e) {
            System.out.println("Соединение не установлено");
        }
        return null;
    }

}
