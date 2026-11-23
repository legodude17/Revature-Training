package com.banking.database;

import com.banking.model.Account;
import com.banking.model.Customer;
import com.banking.model.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Placeholder data layer. Currently backed by in-memory lists; will later be
 * replaced with a real database connection while keeping the same method signatures.
 */
public class DBConnection {
    private final List<Account> accounts = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final List<Transaction> transactions = new ArrayList<>();

    // ---------- Account ----------

    public void insertAccount(Account account) {
        accounts.add(account);
    }

    public Account queryAccount(long accountNumber) {
        for (Account a : accounts) {
            if (a.account_number == accountNumber) return a;
        }
        return null;
    }

    public List<Account> queryAccountsByCustomer(int customerId) {
        List<Account> result = new ArrayList<>();
        for (Account a : accounts) {
            if (a.customer_id == customerId) result.add(a);
        }
        return result;
    }

    public List<Account> queryAllAccounts() {
        return new ArrayList<>(accounts);
    }

    public boolean deleteAccount(long accountNumber) {
        return accounts.removeIf(a -> a.account_number == accountNumber);
    }

    // ---------- Customer ----------

    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer queryCustomer(int id) {
        for (Customer c : customers) {
            if (c.id == id) return c;
        }
        return null;
    }

    public List<Customer> queryAllCustomers() {
        return new ArrayList<>(customers);
    }

    public boolean deleteCustomer(int id) {
        return customers.removeIf(c -> c.id == id);
    }

    // ---------- Transaction ----------

    public void insertTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Transaction queryTransaction(int id) {
        for (Transaction t : transactions) {
            if (t.id == id) return t;
        }
        return null;
    }

    public List<Transaction> queryTransactionsByAccount(long accountNumber) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.account_number == accountNumber) result.add(t);
        }
        return result;
    }

    public List<Transaction> queryAllTransactions() {
        return new ArrayList<>(transactions);
    }

    public boolean deleteTransaction(int id) {
        return transactions.removeIf(t -> t.id == id);
    }
}
