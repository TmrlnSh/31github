package com.automation.utils;

import java.sql.*;

public class DatabaseUtils {

    static String url = ConfigReader.getProperty("db.url");
    static String username = ConfigReader.getProperty("db.username");
    static String password = ConfigReader.getProperty("db.password");
    static Statement stmt;

    public static void initDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Just for Git
    }

    public static ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
