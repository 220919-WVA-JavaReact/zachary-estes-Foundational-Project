package com.revatureproj.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureproj.dao.TicketsDAO;
import com.revatureproj.dao.TicketsDAOImpl;
import com.revatureproj.models.Tickets;
import com.revatureproj.models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@WebServlet(
        urlPatterns = "/new-ticket",
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(
                        name = "newTicket-servlet-key",
                        value = "newTicket-servlet-value"
                )
        }
)
public class NewTicketServlet extends HttpServlet {

    private final ObjectMapper mapper;

    private TicketsDAO td = new TicketsDAOImpl();

    private Users user;

    private Tickets ticket;

    public NewTicketServlet(ObjectMapper mapper, TicketsDAO td, Users user){
        this.mapper=mapper;
        this.td = td;
        this.user = user;
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    //new ticket
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        HttpSession session = req.getSession(false);
        if (session == null){
            resp.setStatus(400);
            HashMap<String, Object> errorMessage = new HashMap<>();
            resp.getWriter().write(mapper.writeValueAsString(errorMessage));
            return;
        }else {
            Tickets newTicket = mapper.readValue(req.getInputStream(), Tickets.class);
            int provDollarAmt = newTicket.getDollarAmount();
            String provDescription = newTicket.getDescription();
            Tickets ticket = new Tickets(provDollarAmt, provDescription, user.getUsername());
            boolean success = td.createTicket(ticket, user);
            if(success){
                resp.setStatus(201);
                resp.getWriter().write("Your ticket has been submitted");
            }else{
                resp.setStatus(400);
                resp.getWriter().write("You must provide a dollar amount and description");
            }
        }
    }

    //view own previous tickets
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        HttpSession session = req.getSession(false);
        if (session == null){
            resp.setStatus(400);
            HashMap<String, Object> errorMessage = new HashMap<>();
            resp.getWriter().write(mapper.writeValueAsString(errorMessage));
            return;
        }else {
            List<Tickets> tickets = td.getOwnTickets();
            String respPayload = mapper.writeValueAsString(tickets);
            resp.setContentType("application/json");
            resp.getWriter().write(respPayload);
            }
    }
}
