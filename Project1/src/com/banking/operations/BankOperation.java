package com.banking.operations;

import java.util.Scanner;

import com.banking.database.DBConnection;
import com.banking.exception.InsufficientBalanceException;
import com.banking.exception.InvalidAccountException;

public abstract class BankOperation {
    public abstract void getInput(Scanner sc);

    public abstract void execute(DBConnection conn) throws InvalidAccountException, InsufficientBalanceException;
}
