package com.revatureproj.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureproj.dao.UsersDAO;
import com.revatureproj.dao.UsersDAOImpl;
import com.revatureproj.models.Users;
import com.revatureproj.servlets.LoginServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserService {

    ObjectMapper mapper;

    public UserService(ObjectMapper mapper){
        this.mapper=mapper;
    }

    LoginServlet ls;
    public UserService() {
    }

    UsersDAO ud = new UsersDAOImpl();

    Scanner sc = new Scanner(System.in);

    public Users login(){
        System.out.println("Please enter your username: ");
        String username = sc.nextLine();
        System.out.println("Please enter your password: ");
        String password = sc.nextLine();

        Users user = ud.getByLogin(username);
        if(user.getEmployee_id() == 0){
            System.out.println("No user associated with that username");
        }else{
            if (user.getPassword().equals(password)){
                System.out.println("Successfully logged in");
                return user;
            }
        }
        return null;
    }
/*
public void login2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Users> users = ud.getAllUsers();

    HashMap<String, Object> credentials = mapper.readValue(req.getInputStream(), HashMap.class);


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
*/
    public Users register(){

        Map newUser = new HashMap<>();

        String provFirst = (String) newUser.get("first_name");
        String provLast = (String) newUser.get("last_name");
        String provUsername = (String) newUser.get("username");
        String provPassword = (String) newUser.get("password");
        Boolean isManager = (boolean) newUser.get("isManager");

        Users user = new Users(provFirst, provLast,provUsername, provPassword, isManager);

        if (user.getEmployee_id() != 0){
            System.out.println("You have successfully registered");
            return user;
        }
        return null;
    }
}
