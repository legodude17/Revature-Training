package com.banking.operations;

import java.util.Scanner;

import com.banking.database.DBConnection;
import com.banking.model.Account;
import com.banking.model.TransactionType;

public class WithdrawOperation extends BankOperationWithAccount {
        private double withdrawAmount;

    @Override
    public void getInput(Scanner sc) {
        super.getInput(sc);
        System.out.print("Enter the amount to withdraw: ");
        withdrawAmount = sc.nextDouble();
        sc.nextLine();
    }

    @Override
    protected void execute_inner(DBConnection conn, Account account) {
        if (withdrawAmount <= 0) {
            System.out.println("Can only withdraw a positive amount.");
            return;
        }

        if (account.balance < withdrawAmount) {
            System.out.println("Insufficient funds.");
        }

        account.balance -= withdrawAmount;

        addTransaction(conn, withdrawAmount, TransactionType.WITHDRAWL);
    }
}
