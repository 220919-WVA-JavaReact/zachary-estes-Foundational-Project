package com.revatureproj.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureproj.dao.UsersDAO;
import com.revatureproj.dao.UsersDAOImpl;
import com.revatureproj.models.Users;
import com.revatureproj.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

      //  Users user = ud.getByLogin(username);
      //  List<users> userList = ud.getByLogin();

        HashMap<String, Object> credentials = mapper.readValue(req.getInputStream(), HashMap.class);

        String provUserName = (String) credentials.get("username");
        String provPassword = (String) credentials.get("password");

        Users users = ud.getByLogin(provUserName);

        for (Users user: users){

        }
    }


    //logging out
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
