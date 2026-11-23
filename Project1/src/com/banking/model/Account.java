package com.banking.model;

import java.util.Date;

public abstract class Account {
    public long account_number;
    public int customer_id;
    public double balance;
    public Date date;

    public abstract String getType();
}
