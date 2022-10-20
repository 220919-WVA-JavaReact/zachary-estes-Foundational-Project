package com.revatureproj.dao;

import com.revatureproj.models.Tickets;
import com.revatureproj.models.Users;

import java.util.List;

public interface TicketsDAO {

    boolean createTicket(Tickets tickets, Users users);

    List<Tickets> getTickets();

    List<Tickets> getOwnTickets();
}
