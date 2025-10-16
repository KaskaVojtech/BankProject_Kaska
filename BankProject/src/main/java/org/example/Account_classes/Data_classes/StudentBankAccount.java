package org.example.Account_classes.Data_classes;

import org.example.Account_classes.Data_classes.Core.BankAccountWithCard;
import org.example.AccountOwner_classes.Data_classes.Core_classes.BaseAccountOwner;
import org.example.AccountOwner_classes.Data_classes.StudentAccountOwner;

public class StudentBankAccount extends BankAccountWithCard {

    String school;

    public StudentBankAccount(String uuid, double balance, String accountNumber, StudentAccountOwner owner) {
        super(uuid, balance, accountNumber, (BaseAccountOwner)owner);
        this.school = owner.getSchool();
    }
}
