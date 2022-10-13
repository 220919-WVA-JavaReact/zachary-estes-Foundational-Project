package com.revatureproj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static Connection conn = null;

    private ConnectionUtil(){

    }

    public static Connection getConnection(){
        try{
            if (conn != null && !conn.isClosed()){
                System.out.println("using a previously made connection");
                return conn;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        String url = System.getenv("url");
        String username = System.getenv("username");
        String password = System.getenv("password");

        try {
            conn = DriverManager.getConnection(url,username, password);
            System.out.println("established connection to database");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
        return conn;
    }
}
