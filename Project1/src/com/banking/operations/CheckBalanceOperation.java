package com.banking.operations;

import com.banking.database.DBConnection;
import com.banking.model.Account;

public class CheckBalanceOperation extends BankOperationWithAccount {
    @Override
    protected void execute_inner(DBConnection conn, Account account) {
        System.out.println("Balance: " + account.balance);
    }
}
