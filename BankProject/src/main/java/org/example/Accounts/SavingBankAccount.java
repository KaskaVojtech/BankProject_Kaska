package org.example.Accounts;

import org.example.AccountsOwners.BaseAccountOwner;

public class SavingBankAccount extends BaseAccount {
    double interestRate;

    public SavingBankAccount(String uuid, double balance, String accountNumber, BaseAccountOwner owner, double interestRate) {
        super(uuid, balance, accountNumber, owner);
        this.interestRate = interestRate;
    }
}
