package org.example.Account_classes.Data_classes.Core;

import org.example.AccountOwner_classes.Data_classes.Core_classes.BaseAccountOwner;
import org.example.Account_classes.Transaction_classes.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BaseAccount {
    private String uuid;

    private double balance;

    private String accountNumber;

    private BaseAccountOwner owner;

    public List<Transaction> transactions;

    public BaseAccount(String uuid, double balance, String accountNumber, BaseAccountOwner owner) {
        this.uuid = uuid;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.transactions = new ArrayList<>();
    }

    public String getUuid() {
        return uuid;
    }
    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public BaseAccountOwner getOwner() {
        return owner;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
