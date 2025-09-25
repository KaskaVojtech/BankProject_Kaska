package org.example.Services;

import org.example.Accounts.BaseAccount;

public class AccountSecurityService {

    public void addBalanceChecker(BaseAccount account, double balance) {
        if(balance <= 0) {
            throw new IllegalArgumentException("Balance is negative");
        }
        if(balance > 10000){
            throw new IllegalArgumentException("You can not add more than 10000");
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
