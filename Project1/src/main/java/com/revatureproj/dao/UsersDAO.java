package com.revatureproj.dao;

import com.revatureproj.models.Users;

import java.util.List;

public interface UsersDAO {
    // get user by their login info
    Users getByLogin(String username);
    // register new user
    Users registerEmployee(String first, String last, String username, String password, boolean isManager);

    List<Users> getAllUsers();
}
