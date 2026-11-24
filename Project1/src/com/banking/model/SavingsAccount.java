package com.banking.model;

import java.util.Date;

public class SavingsAccount extends Account {
    public SavingsAccount(long account_number, int customer_id, double balance, Date date) {
        super(account_number, customer_id, balance, date);
    }

    @Override
    public String getType() {
        return "Savings";
    }
}
