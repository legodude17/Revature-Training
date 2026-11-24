package com.banking.operations;

import java.util.Scanner;

import com.banking.database.DBConnection;
import com.banking.model.Customer;

public class CreateCustomerOperation extends BankOperation {
    private String name;
    private String email;
    private String phone;

    @Override
    public void getInput(Scanner sc) {
        System.out.print("Enter the customer name: ");
        name = sc.nextLine();
        System.out.print("Enter the customer email: ");
        email = sc.nextLine();
        System.out.print("Enter the customer phone: ");
        phone = sc.nextLine();
    }

    @Override
    public void execute(DBConnection conn) {
        Customer newCustomer = new Customer(
                (int) Math.round(Math.random() * 100000000),
                name,
                email,
                phone);
        name = null;
        email = null;
        phone = null;
        
        conn.insertCustomer(newCustomer);

        System.out.println("Customer " + newCustomer.id + " created!");
    }
}
