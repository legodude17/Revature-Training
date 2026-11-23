package com.banking.operations;

import java.util.Date;
import java.util.Scanner;

import com.banking.database.DBConnection;
import com.banking.model.Account;
import com.banking.model.Transaction;
import com.banking.model.TransactionType;

public abstract class BankOperationWithAccount extends BankOperation {
    protected long accountNumber;

    @Override 
    public void getInput(Scanner sc) {
        System.out.print("Enter your account number: ");
        accountNumber = sc.nextLong();
        sc.nextLine();
    }

    @Override 
    public void execute(DBConnection conn) {
        Account account = conn.queryAccount(accountNumber);
        if (account == null) {
            System.out.println("Invalid account number.");
            return;
        }

        execute_inner(conn, account);
    }

    protected abstract void execute_inner(DBConnection conn, Account account);

    protected void addTransaction(DBConnection conn, double amount, TransactionType type) {
        Transaction newTransaction = new Transaction();
        newTransaction.id = (int) Math.round(Math.random() * 10000000);
        newTransaction.account_number = accountNumber;
        newTransaction.amount = amount;
        newTransaction.date = new Date();
        newTransaction.type = type;

        conn.insertTransaction(newTransaction);
    }
}
