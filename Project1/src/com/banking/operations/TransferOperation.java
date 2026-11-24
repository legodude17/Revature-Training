package com.banking.operations;

import java.util.Date;
import java.util.Scanner;

import com.banking.database.DBConnection;
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
    public void execute(DBConnection conn) {
        Account fromAccount = conn.queryAccount(fromAccountNum);
        if (fromAccount == null) {
            System.out.println("Invalid sender account.");
            return;
        }

        Account toAccount = conn.queryAccount(toAccountNum);
        if (toAccount == null) {
            System.out.println("Invalid reciever account");
            return;
        }

        if (fromAccount == toAccount) {
            System.out.println("Cannot transfer between the same account.");
            return;
        }

        if (fromAccount.balance < amount) {
            System.out.println("Sender account has insufficient funds.");
        }

        fromAccount.balance -= amount;
        toAccount.balance += amount;

        String reference = fromAccountNum + "->" + toAccountNum + ":" + amount;
        Transaction transactionSend = new Transaction(
                0, fromAccountNum, TransactionType.TRANSFER, -amount, reference, new Date());
        Transaction transactionRecieve = new Transaction(
                0, toAccountNum, TransactionType.TRANSFER, amount, reference, new Date());
        conn.insertTransaction(transactionSend);
        conn.insertTransaction(transactionRecieve);
    }
}
