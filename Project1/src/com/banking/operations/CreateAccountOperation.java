package com.banking.operations;

import java.time.LocalDate;
import java.util.Scanner;

import com.banking.database.DBConnection;
import com.banking.model.Account;
import com.banking.model.CurrentAccount;
import com.banking.model.SavingsAccount;

public class CreateAccountOperation extends BankOperation {
    private int customerId;
    private boolean accountType;

    @Override
    public void getInput(Scanner sc) {
        System.out.print("Customer ID: ");
        customerId = sc.nextInt();
        sc.nextLine();

        System.out.print("Current account? (True for current account, false for savings account) ");
        accountType = sc.nextBoolean();
        sc.nextLine();
    }

    @Override
    public void execute(DBConnection conn) {
        Account newAccount;
        long accountNumber = Math.round(Math.random() * 10000000);
        if (accountType) {
            newAccount = new CurrentAccount(accountNumber, customerId, 0, LocalDate.now());
        } else {
            newAccount = new SavingsAccount(accountNumber, customerId, 0, LocalDate.now());
        }

        conn.insertAccount(newAccount);

        System.out.println("Account " + newAccount.account_number + " created.");
    }
}
