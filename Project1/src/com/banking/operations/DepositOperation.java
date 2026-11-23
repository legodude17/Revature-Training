package com.banking.operations;

import java.util.Scanner;

import com.banking.database.DBConnection;
import com.banking.model.Account;
import com.banking.model.TransactionType;

public class DepositOperation extends BankOperationWithAccount {
    private double depositAmount;

    @Override
    public void getInput(Scanner sc) {
        super.getInput(sc);
        System.out.print("Enter the amount to deposit: ");
        depositAmount = sc.nextDouble();
        sc.nextLine();
    }

    @Override
    protected void execute_inner(DBConnection conn, Account account) {
        if (depositAmount <= 0) {
            System.out.println("Can only deposit a positive amount.");
            return;
        }

        account.balance += depositAmount;

        addTransaction(conn, depositAmount, TransactionType.DEPOSIT);
    }
}
