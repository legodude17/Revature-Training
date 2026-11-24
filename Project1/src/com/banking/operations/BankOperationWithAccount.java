package com.banking.operations;

import java.time.LocalDate;
import java.util.Scanner;

import com.banking.database.DBConnection;
import com.banking.exception.InsufficientBalanceException;
import com.banking.exception.InvalidAccountException;
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
    public void execute(DBConnection conn) throws InvalidAccountException, InsufficientBalanceException {
        Account account = conn.queryAccount(accountNumber);
        if (account == null) {
            throw new InvalidAccountException("Invalid account number");
        }

        execute_inner(conn, account);
    }

    protected abstract void execute_inner(DBConnection conn, Account account) throws InsufficientBalanceException;

    protected void addTransaction(DBConnection conn, double amount, TransactionType type) {
        Transaction newTransaction = new Transaction(
                (int) Math.round(Math.random() * 10000000),
                accountNumber,
                type,
                amount,
                null,
                LocalDate.now());

        conn.insertTransaction(newTransaction);
    }
}
