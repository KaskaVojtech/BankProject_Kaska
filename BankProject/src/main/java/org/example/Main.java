package org.example;

import org.example.Accounts.BaseAccount;
import org.example.Services.BankAccountService;
import org.example.Factories.BankAccountFactory;
import org.example.Factories.AccountOwnerFactory;
import org.example.AccountsOwners.StudentAccountOwner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccountFactory bankAccountFactory = new BankAccountFactory();
        BankAccountService bankAccountService = new BankAccountService();

        AccountOwnerFactory accountOwnerFactory = new AccountOwnerFactory();

        BaseAccount studentskyAccount = bankAccountFactory.createStudentBankAccount
                (
                1000,
                accountOwnerFactory.createStudentAccountOwner("Prokop", "Buben", "Kyberna")
                );

        if(studentskyAccount.getOwner() instanceof StudentAccountOwner) {
            System.out.println(((StudentAccountOwner) studentskyAccount.getOwner()).getSchool());
        }

        System.out.println(studentskyAccount.getBalance());

        bankAccountService.increaseBalance(studentskyAccount, 100000);

        System.out.println(studentskyAccount.getBalance());



    }
}