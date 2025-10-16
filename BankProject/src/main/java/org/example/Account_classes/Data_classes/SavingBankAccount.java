package org.example.Account_classes.Data_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.AccountOwner_classes.Data_classes.Core_classes.BaseAccountOwner;

public class SavingBankAccount extends BaseAccount {
    double interestRate;

    public SavingBankAccount(String uuid, double balance, String accountNumber, BaseAccountOwner owner, double interestRate) {
        super(uuid, balance, accountNumber, owner);
        this.interestRate = interestRate;
    }
}
