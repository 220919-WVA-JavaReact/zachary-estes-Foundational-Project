package com.revature.service;

import com.revature.dao.TicketsDAO;
import com.revature.dao.TicketsDAOImpl;
import com.revature.models.Tickets;
import com.revature.models.Users;

import java.util.Scanner;

public class TicketsService {

    TicketsDAO td = new TicketsDAOImpl();
    Scanner sc = new Scanner(System.in);

    public void createTicket(Users user){
        System.out.println("Enter the amount you would like to be reimbursed: ");
        int dollarAmount = sc.nextInt();
        sc.nextLine();
        System.out.println("Provide a brief explanation for this reimbursement");
        String description = sc.nextLine();

        Tickets ticket = new Tickets(dollarAmount,description, user.getUsername());

        boolean success = td.createTicket(ticket, user);
        if(success){
            System.out.println("Successfully created a ticket ");
        }else{
            System.out.println("Something went wrong");
        }
    }
}
