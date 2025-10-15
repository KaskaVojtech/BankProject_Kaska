package org.example.Accounts;

import org.example.AccountsOwners.BaseAccountOwner;
import org.example.AccountsOwners.StudentAccountOwner;

public class StudentBankAccount extends BankAccountWithCard{

    String school;

    public StudentBankAccount(String uuid, double balance, String accountNumber, StudentAccountOwner owner) {
        super(uuid, balance, accountNumber, (BaseAccountOwner)owner);
        this.school = owner.getSchool();
    }
}
