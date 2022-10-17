package com.revatureproj.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureproj.dao.UsersDAO;
import com.revatureproj.dao.UsersDAOImpl;
import com.revatureproj.models.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class LoginServlet extends HttpServlet {

    private final ObjectMapper mapper;

    private final UsersDAO ud = new UsersDAOImpl();;

    public LoginServlet(ObjectMapper mapper){
        this.mapper=mapper;
    }


    //logging in
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Users> users = ud.getAllUsers();

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

        resp.setStatus(400);
        resp.setContentType("application/json");

        HashMap<String, Object> errorMessage = new HashMap<>();

        errorMessage.put("Status code", 400);
        errorMessage.put("Message", "No user found with provided credentials");
        errorMessage.put("Timestamp", LocalDateTime.now().toString());

        resp.getWriter().write(mapper.writeValueAsString(errorMessage));
    }


    //logging out
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if(session != null){
            System.out.println(session.getAttribute("auth-user"));
            session.invalidate();
        }

        resp.setStatus(204);
    }
}
