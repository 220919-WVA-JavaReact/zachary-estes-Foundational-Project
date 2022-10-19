package com.revatureproj.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @Override
    public void init() throws ServletException {
        super.init();
    }

    //new ticket
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    //view own previous tickets
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
