package com.revature.dao;

import com.revature.models.Tickets;
import com.revature.models.Users;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketsDAOImpl implements TicketsDAO {

    @Override
    public boolean createTicket(Tickets tickets, Users users) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO tickets (dollar_amount, description, username) VALUES (?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, tickets.getDollarAmount());
            stm.setString(2, tickets.getDescription());
            stm.setString(3, users.getUsername());

            int rowsUpdated = stm.executeUpdate();

            if (rowsUpdated == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong ");
            e.printStackTrace();
        }
        return false;
    }
}