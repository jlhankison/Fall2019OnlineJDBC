package com.jdbc.day1;

import java.sql.*;

public class BasicTest {

    public static void main(String[] args) throws SQLException {
        String URL = "jdbc:oracle:thin:@3.87.185.197:1521:xe";
        String username = "system";
        String password = "system";

        // establishes connection to database
        Connection connection = DriverManager.getConnection(URL, username, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees;");

        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }

        connection.close();
    }
}
