package com.revatureproj.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureproj.dao.UsersDAO;
import com.revatureproj.dao.UsersDAOImpl;
import com.revatureproj.models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@WebServlet(
        urlPatterns = "/login",
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(
                        name = "login-servlet-key",
                        value = "login-servlet-value"
                )
        }
)
public class LoginServlet extends HttpServlet {

    private final ObjectMapper mapper;

    private UsersDAO ud = new UsersDAOImpl();

    public LoginServlet(ObjectMapper mapper, UsersDAO ud){

        this.mapper=mapper;
        this.ud = ud;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG] - LoginServlet Instantiated!");
        System.out.println("[LOG] - Init param login-servlet-key: " + this.getServletConfig().getInitParameter("login-servlet-key"));
        System.out.println("[LOG] - Init param test-init-key: " + this.getServletConfig().getInitParameter("test-init-key"));
        System.out.println("[LOG] - Context param test-init-key: " + this.getServletContext().getInitParameter("test-context-key"));
    }

    //logging in
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Users> users = ud.getAllUsers();

        HashMap<String, Object> credentials = mapper.readValue(req.getInputStream(), HashMap.class);

        String provUserName = (String) credentials.get("username");
        String provPassword = (String) credentials.get("password");

        for (Users user : users) {
            if (provUserName.equals(user.getUsername()) && provPassword.equals(user.getPassword())) {
                System.out.println("[LOG] - found user!");

                HttpSession session = req.getSession();
                session.setAttribute("auth-user", user);

                resp.getWriter().println(user);

                resp.setStatus(204);
                return;
            } else {

                resp.setStatus(400);
                resp.setContentType("application/json");

                HashMap<String, Object> errorMessage = new HashMap<>();

                errorMessage.put("Status code", 400);
                errorMessage.put("Message", "No user found with provided credentials");
                errorMessage.put("Timestamp", LocalDateTime.now().toString());

                resp.getWriter().write(mapper.writeValueAsString(errorMessage));
            }
        }
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
