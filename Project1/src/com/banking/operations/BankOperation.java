package com.banking.operations;

import java.util.Scanner;

public abstract class BankOperation {
    public abstract void getInput(Scanner scanner);

    public abstract void execute();
}
