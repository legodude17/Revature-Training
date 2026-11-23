package com.banking.model;

public class SavingsAccount extends Account {
    @Override
    public String getType() {
        return "Savings";
    }
}
