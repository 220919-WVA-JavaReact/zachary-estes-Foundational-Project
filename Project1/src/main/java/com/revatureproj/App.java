package com.revatureproj;

import com.revatureproj.models.Users;
import com.revatureproj.service.TicketsService;
import com.revatureproj.service.UserService;

import java.util.Scanner;



public class App {
    static Scanner sc = new Scanner(System.in);

    static UserService us = new UserService();

    static TicketsService ts = new TicketsService();

    public static void main(String[] args) {

        Users loggedInUser = null;
        boolean on = true;

        while (on) {
            if(loggedInUser == null){
                System.out.println("Welcome to Expense Reimbursement Station!" + "\n"
                        + "Please press the number for the task you want to do" + "\n"
                        + "1. Login to my account" + "\n"
                        + "2. Create new account " + "\n"
                        + "3. Exit "
                );
                String choice = sc.nextLine();

                switch (choice){
                    case "1":
                        loggedInUser = us.login();
                        break;
                    case "2":
                        loggedInUser = us.register();
                        break;
                    case  "3":
                        on = false;
                        break;
                    default:
                        System.out.println("Invalid response");
                }
            } else {
                System.out.println("Please press the number for the task you want to do" + "\n"
                        + "1. Create a new reimbursement request " + "\n"
                        + "2. Exit "
                );
                String choice = sc.nextLine();

                switch (choice){
                    case "1":
                        ts.createTicket(loggedInUser);
                        break;
                    case "2":
                        on = false;
                        break;
                    default:
                        System.out.println("Invalid response");
                }
            }
        }
    }
}
