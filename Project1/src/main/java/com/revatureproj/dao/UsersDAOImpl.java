package com.revature.dao;

import com.revature.models.Users;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAOImpl  implements UsersDAO{
    @Override
    public Users getByLogin(String username) {
        Users user = new Users();

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM employees where username = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs;

            if ((rs = stm.executeQuery()) != null){
                rs.next();
                String receivedFirst = rs.getString("first_name");
                String receivedLast = rs.getString("last_name");
                String receivedUsername = rs.getString("username");
                String receivedPassword = rs.getString("password");
                boolean receivedIsManager = rs.getBoolean("isManager");
                int receivedUserId = rs.getInt("employee_id");

                user = new Users(receivedFirst,receivedLast,receivedUsername,receivedPassword,receivedIsManager,receivedUserId);
            }

        }catch (SQLException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Users registerEmployee(String first, String last, String username, String password, boolean isManager) {

        Users user = new Users();

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO employees (first_name, last_name, username, password) VALUES (?,?,?,?) RETURNING *";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, first);
            stm.setString(2, last);
            stm.setString(3, username);
            stm.setString(4, password);
            //stm.setBoolean(5, isManager);

            ResultSet rs;

            if ((rs = stm.executeQuery()) != null){
                rs.next();
                String receivedFirst = rs.getString("first_name");
                String receivedLast = rs.getString("last_name");
                String receivedUsername = rs.getString("username");
                String receivedPassword = rs.getString("password");
                //boolean receivedIsManager = rs.getBoolean("isManager");

                user = new Users(receivedFirst,receivedLast,receivedUsername,receivedPassword);
            }

        }catch (SQLException e){
            System.out.println("Unable to register user, username is not available");
        }
        return user;
    }
}
