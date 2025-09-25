package org.example.Factories;

import org.example.Accounts.AdultBankAccount;
import org.example.Accounts.SavingBankAccount;
import org.example.Accounts.StudentBankAccount;
import org.example.Services.UniqueNumberGenerator;
import org.example.AccountsOwners.BaseAccountOwner;
import org.example.AccountsOwners.StudentAccountOwner;

public class BankAccountFactory {

    private UniqueNumberGenerator uniqueNumberGenerator = new UniqueNumberGenerator();

    public AdultBankAccount createBankAccount(BaseAccountOwner human) {
        return new AdultBankAccount(uniqueNumberGenerator.makeID_UUID(), human);
    }

    public SavingBankAccount createSavingBankAccount(double balance, BaseAccountOwner human, double interestRate){
        return new SavingBankAccount(uniqueNumberGenerator.makeID_UUID(), balance, uniqueNumberGenerator.makeAccountNumber(),human,interestRate );
    }

    public StudentBankAccount createStudentBankAccount(double balance, StudentAccountOwner human){
        return new StudentBankAccount(uniqueNumberGenerator.makeID_UUID(), balance, uniqueNumberGenerator.makeAccountNumber(), human);
    }
}
