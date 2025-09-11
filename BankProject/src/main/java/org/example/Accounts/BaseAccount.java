package org.example.Accounts;

import org.example.people.BaseHuman;

public class BaseAccount {
    private String uuid;

    private double balance;

    private String accountNumber;

    private BaseHuman owner;

    public BaseAccount(String uuid, double balance, String accountNumber, BaseHuman owner) {
        this.uuid = uuid;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.owner = owner;
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

    public BaseHuman getOwner() {
        return owner;
    }

    public void AddBalance(double balance) {
        this.balance += balance;
    }

    public void DecreaseBalance(double balance) {
        if(this.balance - balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance -= balance;
    }
}
