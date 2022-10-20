package com.revatureproj.dao;

import com.revatureproj.models.Users;
import com.revatureproj.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOImpl  implements UsersDAO{

    UsersDAO ud = new UsersDAOImpl();

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
    public boolean registerEmployee(Users user) {
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO employees (first_name, last_name, username, password, isManager) VALUES (?,?,?,?,?) RETURNING *";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user.getFirst());
            stm.setString(2, user.getLast());
            stm.setString(3, user.getUsername());
            stm.setString(4, user.getPassword());
            stm.setBoolean(5, user.isManager());

            int rowsUpdated = stm.executeUpdate();

            if(rowsUpdated == 5){
                return true;
            }
        }catch (SQLException e){
            System.out.println("Unable to register user, username is not available");
        }
        return false;
    }

    @Override
    public List<Users> getAllUsers(){

        List<Users> usersList = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM employees";
            PreparedStatement stm = conn.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()){

                Users user = new Users();

                user.setFirst(rs.getString("first_name"));
                user.setLast(rs.getString("last_name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setManager(rs.getBoolean("isManager"));
                user.setEmployee_id(rs.getInt("employee_id"));

                usersList.add(user);

            }
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return usersList;
    }
}
