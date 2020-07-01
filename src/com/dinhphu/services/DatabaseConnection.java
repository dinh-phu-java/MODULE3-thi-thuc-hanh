package com.dinhphu.services;

import java.sql.*;

public class DatabaseConnection {
    private static final String url="jdbc:mysql://localhost:3306/thi_module_3";
    private static final String host="root";
    private static final String password="qazWSX1@";

    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(url,host,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


}
