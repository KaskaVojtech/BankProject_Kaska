package org.example.Accounts;

import org.example.people.BaseHuman;
import org.example.people.Student;

public class StudentBankAccount extends BaseAccount{

    String school;

    public StudentBankAccount(String uuid, double balance, String accountNumber, Student owner) {
        super(uuid, balance, accountNumber, (BaseHuman)owner);
        this.school = owner.GetSchool();
    }
}
