package com.banking.operations;

import java.util.Scanner;

import com.banking.database.DBConnection;

public abstract class BankOperation {
    public abstract void getInput(Scanner sc);

    public abstract void execute(DBConnection conn);
}
