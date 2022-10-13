package com.revature.dao;

import com.revature.models.Users;

public interface UsersDAO {
    // get user by their login info
    Users getByLogin(String username);
    // register new user
    Users registerEmployee(String first, String last, String username, String password, boolean isManager);
}
