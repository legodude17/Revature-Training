package com.banking.model;

import java.time.LocalDate;

public class Transaction {
    public int id;
    public long account_number;
    public TransactionType type;
    public double amount;
    public String reference;
    public LocalDate date;

    public Transaction(int id, long account_number, TransactionType type, double amount, String reference, LocalDate date) {
        this.id = id;
        this.account_number = account_number;
        this.type = type;
        this.amount = amount;
        this.reference = reference;
        this.date = date;
    }
}
