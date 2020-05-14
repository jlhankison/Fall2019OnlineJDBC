package com.jdbc.day2;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseTests {

    final String DB_URL = "jdbc:oracle:thin:@3.87.185.197:1521:xe";
    final String DB_USER = "hr";
    final String DB_PASSWORD = "hr";

    @Test
        public void getEmployeesData() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String QUERY = "SELECT * FROM employees";
        ResultSet resultSet = statement.executeQuery(QUERY);

        List<Integer> employeeIDs = new ArrayList<>();
        List<String> employeeNames = new ArrayList<>();
        List<Map<String, Integer>> employeeIDsMap = new ArrayList<>();

        while (resultSet.next()){
            Map<String, Integer> map = new HashMap<>();
            map.put("employee_id", resultSet.getInt("employee_id"));
            employeeIDsMap.add(map);

            employeeIDs.add(resultSet.getInt("employee_id"));
            employeeNames.add(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));



        }
        System.out.println(employeeIDs);
        System.out.println(employeeNames);
        System.out.println(employeeIDsMap);
        Faker faker = new Faker();

        System.out.println(faker.hipster().word());

        resultSet.close();
        statement.close();
        connection.close();
    }
}
