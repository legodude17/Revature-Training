package com.banking.model;

import java.time.LocalDate;

public class SavingsAccount extends Account {
    public SavingsAccount(long account_number, int customer_id, double balance, LocalDate date) {
        super(account_number, customer_id, balance, date);
    }

    @Override
    public String getType() {
        return "Savings";
    }
}
