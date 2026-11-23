package com.banking.operations;

import com.banking.database.DBConnection;
import com.banking.model.Account;
import com.banking.model.Transaction;

public class ViewTransactionHistoryOperation extends BankOperationWithAccount {
    @Override
    protected void execute_inner(DBConnection conn, Account account) {
        var transactions = conn.queryTransactionsByAccount(accountNumber);
        for (Transaction transaction : transactions) {
            System.out.println("Date: " + transaction.date);
            System.out.println("Type: " + transaction.type);
            System.out.println("Amount: " + transaction.amount);
            if (transaction.reference != null) {
                System.out.println("Ref: " + transaction.reference);
            }
            System.out.println();
        }
    }
}
