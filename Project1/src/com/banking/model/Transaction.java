package com.banking.model;

import java.util.Date;

public class Transaction {
    public int id;
    public long account_number;
    public TransactionType type;
    public double amount;
    public String reference;
    public Date date;

    public Transaction(int id, long account_number, TransactionType type, double amount, String reference, Date date) {
        this.id = id;
        this.account_number = account_number;
        this.type = type;
        this.amount = amount;
        this.reference = reference;
        this.date = date;
    }
}
