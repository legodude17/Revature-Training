package com.banking.model;

public class Customer {
    public int id;
    public String name;
    public String email;
    public String phone;

    public Customer(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
