package com.revatureproj.dao;

import com.revatureproj.models.Tickets;
import com.revatureproj.models.Users;

public interface TicketsDAO {

    boolean createTicket(Tickets tickets, Users users);
}
