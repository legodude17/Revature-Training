package com.banking.model;

import java.util.Date;

public abstract class Account {
    public long account_number;
    public int customer_id;
    public double balance;
    public Date date;

    public Account(long account_number, int customer_id, double balance, Date date) {
        this.account_number = account_number;
        this.customer_id = customer_id;
        this.balance = balance;
        this.date = date;
    }

    public abstract String getType();
}
