package com.banking.model;

import java.util.Date;

public class CurrentAccount extends Account {
    public CurrentAccount(long account_number, int customer_id, double balance, Date date) {
        super(account_number, customer_id, balance, date);
    }

    @Override
    public String getType() {
        return "Current";
    }
}
