package com.revature;

import java.util.Scanner;

import static java.lang.System.exit;


public class App {

    public static void main(String[] args) {
        System.out.println("Welcome to Expense Reimbursement Station!" + "\n"
                + "Please press the number for the task you want to do" + "\n"
                + "1. Login to my account" + "\n"
                + "2. Create new account " + "\n"
                + "3. Exit "
        );

        Scanner sc = new Scanner(System.in);

        String choice = sc.nextLine();

        int ticketId = 0;


        boolean isLoggedIn = false;
        boolean isManager = false;
        boolean on = true;

        while (on == true) {
            if (choice.equals("1")) {
                System.out.println("Please enter your username");
                String username = sc.nextLine();
                System.out.println("Please enter your password");
                String password = sc.nextLine();

                System.out.println("Welcome back! " + username);

                //changes logged in state to true
                isLoggedIn = true;
                System.out.println("Please select a number from the following: " + "\n"
                        + "1. Submit a new reimbursement" + "\n"
                        + "2. Exit"
                );
                String res = sc.nextLine();

                if (res.equals("1")) {

                    System.out.println("Please enter the dollar amount you requesting to be reimbursed ");
                    int dollarAmount = sc.nextInt();

                    System.out.println("Please enter a description for your request");
                    String description = sc.nextLine();

                    System.out.println("Reimbursement " + ticketId + " has been submitted. Thank you!");
                    System.out.println("Please select from one of the following" + "\n"
                            + "1. Create a new Reimbursement Request" + "\n"
                            + "2. Exit"
                    );
                }
            } else if (choice.equals("2")) {

                System.out.println("Hello, are you an employee or manager?");
                String emp = sc.nextLine();

                if (emp.equals("manager")) {

                    System.out.println("Please enter your first name");
                    String first = sc.next();

                    System.out.println("Please enter your last name");
                    String last = sc.next();

                    //check db if username is taken

                    System.out.println("Please enter your desired username");
                    String username = sc.next();

                    System.out.println("Please enter your password");
                    String password = sc.next();

                    System.out.println("Welcome!" + "\n"
                            + "Your username is: " + username
                    );

                    isLoggedIn = true;
                    isManager = true;
                } else if (emp.equals("employee")) {
                    System.out.println("Please enter your first name");
                    String first = sc.next();

                    System.out.println("Please enter your last name");
                    String last = sc.next();

                    //check db if username is taken

                    System.out.println("Please enter your desired username");
                    String username = sc.next();

                    System.out.println("Please enter your password");
                    String password = sc.next();

                    System.out.println("Welcome!" + "\n"
                            + "Your username is: " + username
                    );

                    isLoggedIn = true;
                    
                }
            } else if (choice.equals(3)) {
                System.out.println("Goodbye!");
                exit(0);
            }
        }
    }
}
