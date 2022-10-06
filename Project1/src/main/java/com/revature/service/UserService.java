package com.revature.service;

import com.revature.App;
import com.revature.dao.UsersDAO;
import com.revature.dao.UsersDAOImpl;
import com.revature.models.Users;

import java.sql.SQLOutput;
import java.util.Scanner;

public class UserService {

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

    public Users register(){
        System.out.println("Enter your first name");
        String first = sc.nextLine();
        System.out.println("Enter your last name");
        String last = sc.nextLine();
        System.out.println("Enter your desired username: ");
        String username = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        System.out.println("Are you a manager? Enter Y or N ");
        String respMan = sc.nextLine();
        Boolean isManager = false;
        if (respMan.equals("Y")){
            isManager = true;
        }
        Users user = ud.registerEmployee(first,last,username,password,isManager);


        if (user.getEmployee_id() != 0){
            System.out.println("You have successfully registered");
            return user;
        }
        return null;
    }
}
