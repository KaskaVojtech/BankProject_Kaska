package org.example.Services;

import org.example.Accounts.BaseAccount;

public class BankAccountService {

    private AccountSecurityService accountSecurityService = new AccountSecurityService();

    public void increaseBalance(BaseAccount account, double balance) {
        try{
            accountSecurityService.addBalanceChecker(account, balance);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        account.setBalance(account.getBalance()+balance);
    }

    public void decreaseBalance(BaseAccount account, double balance) {
        try{
            accountSecurityService.decreaseBalance(account, balance);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        account.setBalance(account.getBalance()-balance);
    }
}
