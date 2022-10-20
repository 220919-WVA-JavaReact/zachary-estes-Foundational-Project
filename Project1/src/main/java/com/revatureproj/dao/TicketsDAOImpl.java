package com.revatureproj.dao;

import com.revatureproj.models.Tickets;
import com.revatureproj.models.Users;
import com.revatureproj.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Tickets> getTickets() {

        List<Tickets> tickets = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM tickets WHERE ticket_status = 'PENDING' ";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()){
                Tickets ticket = new Tickets();
                ticket.setTicketId(rs.getInt("ticket_id"));
                ticket.setDollarAmount(rs.getInt("dollar_amount"));
                ticket.setDescription(rs.getString("description"));
                ticket.setUsername(rs.getString("username"));

                tickets.add(ticket);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tickets;
    }

    @Override
    public List<Tickets> getOwnTickets() {
        List<Tickets> tickets = new ArrayList<>();
        Users user = new Users();
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM tickets WHERE username = ? ";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user.getUsername());
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Tickets ticket = new Tickets();
                ticket.setTicketId(rs.getInt("ticket_id"));
                ticket.setDollarAmount(rs.getInt("dollar_amount"));
                ticket.setDescription(rs.getString("description"));
                ticket.setUsername(rs.getString("username"));

                tickets.add(ticket);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tickets;
    }
}