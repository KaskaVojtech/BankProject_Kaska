package org.example.Services;

import org.example.Accounts.BaseAccount;

public class AccountSecurityService {

     int trashhold = 10000;

    public void addBalanceChecker(BaseAccount account, double balance) {
        if(balance <= 0) {
            throw new IllegalArgumentException("Balance is negative");
        }
        if(balance > trashhold) {
            throw new IllegalArgumentException("You can not add more than " + trashhold);
        }
        if(account.getOwner().getFirstName().equals("Filip")) {
            throw new IllegalArgumentException("Filipové nemůžou přidávat peníze");
        }
        //dalsi podminky
    }

    public void decreaseBalance(BaseAccount account, double balance) {
        if(account.getBalance() - balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
    }
}
