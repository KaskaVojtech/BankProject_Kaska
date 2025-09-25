package org.example.Accounts;

import org.example.AccountsOwners.BaseAccountOwner;

public class BaseAccount {
    private String uuid;

    private double balance;

    private String accountNumber;

    private BaseAccountOwner owner;

    public BaseAccount(String uuid, double balance, String accountNumber, BaseAccountOwner owner) {
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

    public BaseAccountOwner getOwner() {
        return owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
