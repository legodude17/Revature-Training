package com.banking.model;

import java.time.LocalDate;

public abstract class Account {
    public long account_number;
    public int customer_id;
    public double balance;
    public LocalDate created_date;

    public Account(long account_number, int customer_id, double balance, LocalDate created_date) {
        this.account_number = account_number;
        this.customer_id = customer_id;
        this.balance = balance;
        this.created_date = created_date;
    }

    public abstract String getType();
}
