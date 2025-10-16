package org.example.Account_classes.Data_classes;

import org.example.Account_classes.Data_classes.Core.BankAccountWithCard;
import org.example.AccountOwner_classes.Data_classes.Core_classes.BaseAccountOwner;

public class BankAccount extends BankAccountWithCard {
    public BankAccount(String uuid, double balance, String accountNumber, BaseAccountOwner owner) {
        super(uuid, balance, accountNumber, owner);
    }
}
