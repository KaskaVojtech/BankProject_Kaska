package org.example.Account_classes.Factories;

import org.example.Account_classes.Data_classes.BankAccount;
import org.example.Account_classes.Data_classes.SavingBankAccount;
import org.example.Account_classes.Data_classes.StudentBankAccount;
import org.example.AccountOwner_classes.Data_classes.AdultAccountOwner;
import org.example.Account_classes.Service_classes.Manager_classes.AccountManager;
import org.example.Helper_classes.Generation_classes.IDGenerator;
import org.example.AccountOwner_classes.Data_classes.Core_classes.BaseAccountOwner;
import org.example.AccountOwner_classes.Data_classes.StudentAccountOwner;

public class BankAccountFactory {

    private IDGenerator IDGenerator = new IDGenerator();

    public AccountManager accountManager;

    public BankAccountFactory(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public BankAccount createBankAccount(double balance, AdultAccountOwner owner) {
        BankAccount acc = new BankAccount(IDGenerator.makeID_UUID(), balance, IDGenerator.makeAccountNumber(), owner);
        accountManager.addAccount(acc);
        return acc;
    }

    public SavingBankAccount createSavingBankAccount(double balance, BaseAccountOwner human, double interestRate){
        SavingBankAccount acc = new SavingBankAccount(IDGenerator.makeID_UUID(), balance, IDGenerator.makeAccountNumber(),human,interestRate );
        accountManager.addAccount(acc);
        return acc;
    }

    public StudentBankAccount createStudentBankAccount(double balance, StudentAccountOwner human){
        StudentBankAccount acc = new StudentBankAccount(IDGenerator.makeID_UUID(), balance, IDGenerator.makeAccountNumber(), human);
        accountManager.addAccount(acc);
        return acc;
    }
}
