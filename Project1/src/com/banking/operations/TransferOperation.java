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

        Transaction transactionSend = new Transaction();
        Transaction transactionRecieve = new Transaction();
        String reference = fromAccountNum + "->" + toAccountNum + ":" + amount;
        transactionSend.account_number = fromAccountNum;
        transactionRecieve.account_number = toAccountNum;
        transactionSend.type = TransactionType.TRANSFER;
        transactionRecieve.type = TransactionType.TRANSFER;
        transactionSend.date = new Date();
        transactionRecieve.date = new Date();
        transactionSend.amount = -amount;
        transactionRecieve.amount = amount;
        transactionSend.reference = reference;
        transactionRecieve.reference = reference;
        conn.insertTransaction(transactionSend);
        conn.insertTransaction(transactionRecieve);
    }
}
