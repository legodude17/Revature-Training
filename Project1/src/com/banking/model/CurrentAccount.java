package com.banking.model;

public class CurrentAccount extends Account {
    @Override
    public String getType() {
        return "Current";
    }
}
