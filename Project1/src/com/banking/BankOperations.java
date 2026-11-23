package com.banking;

import com.banking.operations.BankOperation;
import com.banking.operations.CheckBalanceOperation;
import com.banking.operations.CreateAccountOperation;
import com.banking.operations.CreateCustomerOperation;
import com.banking.operations.DepositOperation;
import com.banking.operations.TransferOperation;
import com.banking.operations.ViewCustomerDetailsOperation;
import com.banking.operations.ViewTransactionHistoryOperation;
import com.banking.operations.WithdrawOperation;

public class BankOperations {
    public static final BankOperation CREATE_CUSTOMER = new CreateCustomerOperation();
    public static final BankOperation CREATE_ACCOUNT = new CreateAccountOperation();
    public static final BankOperation VIEW_CUSTOMER_DETAILS = new ViewCustomerDetailsOperation();
    public static final BankOperation DEPOSIT = new DepositOperation();
    public static final BankOperation WITHDRAW = new WithdrawOperation();
    public static final BankOperation CHECK_BALANCE = new CheckBalanceOperation();
    public static final BankOperation TRANSFER = new TransferOperation();
    public static final BankOperation VIEW_TRANSACTION_HISTORY = new ViewTransactionHistoryOperation();

    private BankOperations() {
    }
}
