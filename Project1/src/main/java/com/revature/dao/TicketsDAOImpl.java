package com.revature.dao;

import com.revature.models.Tickets;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketsDAOImpl implements TicketsDAO{

    @Override
    public boolean createTicket(Tickets ticket) {

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO tickets (username, dollar_amount, description) VALUES (?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, ticket.getUser().getUsername());
            stm.setInt(2, ticket.getDollarAmount());
            stm.setString(3, ticket.getDescription());

            int rowsUpdated = stm.executeUpdate();

            if (rowsUpdated == 1){
                return true;
            }

        } catch (SQLException e){
            System.out.println("Something went wrong ");
            e.printStackTrace();
        }
        return false;
    }
}
