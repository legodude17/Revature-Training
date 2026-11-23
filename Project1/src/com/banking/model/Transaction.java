package com.banking.model;

import java.util.Date;

public class Transaction {
    public int id;
    public long account_number;
    public TransactionType type;
    public double amount;
    public String reference;
    public Date date;
}
