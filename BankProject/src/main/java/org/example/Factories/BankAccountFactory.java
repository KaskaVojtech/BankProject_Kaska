package org.example.Factories;

import org.example.Accounts.AdultBankAccount;
import org.example.Accounts.SavingBankAccount;
import org.example.Accounts.StudentBankAccount;
import org.example.AccountsOwners.AdultAccountOwner;
import org.example.Services.AccountManager;
import org.example.Services.Generators.IDGenerator;
import org.example.AccountsOwners.BaseAccountOwner;
import org.example.AccountsOwners.StudentAccountOwner;

public class BankAccountFactory {

    private IDGenerator IDGenerator = new IDGenerator();

    public AccountManager accountManager;

    public BankAccountFactory(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public AdultBankAccount createAdultBankAccount(double balance, AdultAccountOwner owner) {
        AdultBankAccount acc = new AdultBankAccount(IDGenerator.makeID_UUID(), balance, IDGenerator.makeAccountNumber(), owner);
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
