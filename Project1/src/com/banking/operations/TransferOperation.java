package com.banking.operations;

import java.time.LocalDate;
import java.util.UUID;
import java.util.Scanner;

import com.banking.database.DBConnection;
import com.banking.exception.InsufficientBalanceException;
import com.banking.exception.InvalidAccountException;
import com.banking.model.Account;
import com.banking.model.Transaction;
import com.banking.model.TransactionType;

public class TransferOperation extends BankOperation {
    private long fromAccountNum;
    private long toAccountNum;
    private double amount;

    @Override
    public void getInput(Scanner sc) {
        System.out.print("Enter the sender account number: ");
        fromAccountNum = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter the reciever account number: ");
        toAccountNum = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter the amount to transfer: ");
        amount = sc.nextDouble();
        sc.nextLine();
    }

    @Override
    public void execute(DBConnection conn) throws InvalidAccountException, InsufficientBalanceException {
        Account fromAccount = conn.queryAccount(fromAccountNum);
        if (fromAccount == null) {
            throw new InvalidAccountException("Invalid sender account.");
        }

        Account toAccount = conn.queryAccount(toAccountNum);
        if (toAccount == null) {
            throw new InvalidAccountException("Invalid reciever account");
        }

        if (fromAccountNum == toAccountNum) {
            throw new InvalidAccountException("Cannot transfer between the same account.");
        }

        if (fromAccount.balance < amount) {
            throw new InsufficientBalanceException("Sender account has insufficient funds.");
        }

        fromAccount.balance -= amount;
        toAccount.balance += amount;

        String reference = UUID.randomUUID().toString();
        LocalDate now = LocalDate.now();
        conn.insertTransaction(new Transaction(
                (int) Math.round(Math.random() * 10000000), fromAccountNum, TransactionType.TRANSFER, -amount, reference, now));
        conn.insertTransaction(new Transaction(
                (int) Math.round(Math.random() * 10000000), toAccountNum, TransactionType.TRANSFER, amount, reference, now));
        System.out.printf("Transferred %.2f from %d to %d. Ref: %s%n", amount, fromAccountNum, toAccountNum, reference);
    }
}
