package com.revatureproj.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureproj.dao.TicketsDAO;
import com.revatureproj.dao.TicketsDAOImpl;
import com.revatureproj.models.Tickets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = "/view-ticket",
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(
                        name = "viewTicket-servlet-key",
                        value = "viewTicket-servlet-value"
                )
        }
)
public class ViewTicketServlet extends HttpServlet {

    private final ObjectMapper mapper;

    private TicketsDAO td = new TicketsDAOImpl();

    public ViewTicketServlet(ObjectMapper mapper, TicketsDAO td){
        this.mapper=mapper;
        this.td = td;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG] - Init param ViewTicketServlet-servlet-key: " + this.getServletConfig().getInitParameter("ViewTicketServlet-servlet-key"));
        System.out.println("[LOG] - Init param test-init-key: " + this.getServletConfig().getInitParameter("test-init-key"));
        System.out.println("[LOG] - Context param test-init-key: " + this.getServletContext().getInitParameter("test-context-key"));
    }

    // approve/deny tickets
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    // view pending tickets
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tickets> tickets = td.getTickets();
        String respPayload = mapper.writeValueAsString(tickets);
        resp.setContentType("application/json");
        resp.getWriter().write(respPayload);
    }
}
