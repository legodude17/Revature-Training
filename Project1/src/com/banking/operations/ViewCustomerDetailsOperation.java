package com.banking.operations;

import java.util.Scanner;

import com.banking.database.DBConnection;
import com.banking.model.Customer;

public class ViewCustomerDetailsOperation extends BankOperation {
    private int customerId;
    @Override
    public void getInput(Scanner sc) {
        System.out.print("Customer ID: ");
        customerId = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void execute(DBConnection conn) {
        System.out.println("Customer ID: " + customerId);
        Customer customer = conn.queryCustomer(customerId);
        System.out.println("Name: " + customer.name);
        System.out.println("Email: " + customer.email);
        System.out.println("Phone: " + customer.phone);
    }
}
