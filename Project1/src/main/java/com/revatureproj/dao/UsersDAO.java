package com.revatureproj.dao;

import com.revatureproj.models.Users;

import java.util.List;

public interface UsersDAO {
    // get user by their login info
    Users getByLogin(String username);
    // register new user
   boolean registerEmployee(Users user);

    List<Users> getAllUsers();
}
