package com.revature.dao;

import com.revature.models.Tickets;
import com.revature.models.Users;

public interface TicketsDAO {

    boolean createTicket(Tickets tickets, Users users);
}
