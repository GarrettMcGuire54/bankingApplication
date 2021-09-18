package com.company;

import java.util.Scanner;

import static java.lang.System.out;

public class Account {

    //Class variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Class constructor
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    //Function for Depositing money
    void deposit (int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //Function for Withdrawing money
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    //Function showing the previous transaction
    void getPreviousTransaction () {
        if (previousTransaction > 0) {
            out.println("Deposited " + previousTransaction);
        } else if (previousTransaction < 0) {
            out.println("Withdrew " + Math.abs(previousTransaction));
        } else {
            out.println("No transaction occurred");
        }
    }

    //Function for calculating interest of current funds after a number of years
    void calculateInterest (int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        out.println("The current interest rate is " + (100 * interestRate));
        out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    //Function showing the main menu
    void showMenu () {
        char option = '\0';
        Scanner Keyboard = new Scanner(System.in);
        out.println("Welcome, " + customerName + "!");
        out.println("Your ID is: " + customerID);
        out.println();
        out.println("What would you like to do?");
        out.println();
        out.println("A: Check your balance?");
        out.println("B: Make a deposit");
        out.println("C: Make a withdrawal");
        out.println("D: View previous transaction");
        out.println("E: Calculate interest");
        out.println("F: Exit");

        do {
            out.println();
            out.println("Enter an option: ");
            char option1 = Keyboard.next().charAt(0);
            option = Character.toUpperCase(option1);
            out.println();

            switch(option) {
                //Case 'A' allows the user to check their account balance
                case 'A':
                    out.println("==================================");
                    out.println("Balance = $" + balance);
                    out.println("==================================");
                    out.println();
                    break;
                //Case 'B' allows the user to deposit money into their account
                case 'B' :
                    out.println("Enter an amount to deposit");
                    int amount = Keyboard.nextInt();
                    deposit(amount);
                    out.println();
                    break;
                //Case 'C' allows the user to withdraw money from their bank account
                case 'C' :
                    out.println("Enter an amount to withdraw");
                    int amount2 = Keyboard.nextInt();
                    withdraw(amount2);
                    out.println();
                    break;
                //Case 'D' allows the user to view the previous transaction on their account
                case 'D' :
                    out.println("==================================");
                    getPreviousTransaction();
                    out.println("==================================");
                    out.println();
                    break;
                // Case 'F' exits the user from their account
                case 'F' :
                    out.println("==================================");
                    break;
                default :
                    out.println("Error : Invalid option. Please enter A, B, C, D, E, or F");
                    break;
            }
        } while (option != 'F');
        out.println("Thank you for banking with us!");
    }
}
