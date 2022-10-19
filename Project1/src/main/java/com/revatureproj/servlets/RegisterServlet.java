package com.revatureproj.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureproj.dao.UsersDAO;
import com.revatureproj.dao.UsersDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;

@WebServlet(
        urlPatterns = "/register",
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(
                        name = "register-servlet-key",
                        value = "register-servlet-value"
                )
        }
)
public class RegisterServlet extends HttpServlet {

    private final ObjectMapper mapper;

    private UsersDAO ud = new UsersDAOImpl();

    public RegisterServlet(ObjectMapper mapper, UsersDAO ud){
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null){
            resp.setStatus(400);
            resp.setContentType("application/json");
            HashMap<String, Object> errorMessage = new HashMap<>();
            resp.getWriter().write(mapper.writeValueAsString(errorMessage));
            return;
        }

        HashMap<String, Object> newUser = mapper.readValue(req.getInputStream(), HashMap.class);

        String provFirst = (String) newUser.get("first_name");
        String provLast = (String) newUser.get("last_name");
        String provUsername = (String) newUser.get("username");
        String provPassword = (String) newUser.get("password");
        boolean isManager = (boolean) newUser.get("isManager");

        PrintWriter writer = resp.getWriter();

        ud.registerEmployee(provFirst, provLast,provUsername, provFirst, isManager);

        writer.println(newUser);
    }
}
