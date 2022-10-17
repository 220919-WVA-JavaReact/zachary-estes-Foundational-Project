package com.revatureproj.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureproj.models.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class ViewOwnTicketServlet extends HttpServlet {

    private final ObjectMapper mapper;

    public ViewOwnTicketServlet(ObjectMapper mapper){
        this.mapper=mapper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> credentials = mapper.readValue(req.getInputStream(), HashMap.class);

        String provUserName = (String) credentials.get("username");
        String provPassword = (String) credentials.get("password");

        for (Users user: users){
            if (provUserName.equals(user.getUsername()) && provPassword.equals(user.getPassword())){
                System.out.println("[LOG] - found user!");

                HttpSession session = req.getSession();
                session.setAttribute("auth-user", user);

                resp.setStatus(204);
                return;
            }
        }
    }
}
