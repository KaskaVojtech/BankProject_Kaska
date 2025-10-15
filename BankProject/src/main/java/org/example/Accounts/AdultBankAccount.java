package org.example.Accounts;

import org.example.AccountsOwners.BaseAccountOwner;

public class AdultBankAccount extends BankAccountWithCard {
    public AdultBankAccount(String uuid, double balance, String accountNumber, BaseAccountOwner owner) {
        super(uuid, balance, accountNumber, owner);
    }
}
