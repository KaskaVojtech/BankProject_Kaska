package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Account_classes.Data_classes.BankAccount;
import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Data_classes.SavingBankAccount;
import org.example.Account_classes.Service_classes.Manager_classes.AccountManager;
import org.example.Helper_classes.Other.Cron_classes.CronService;
import org.example.Helper_classes.Other.Cron_classes.CronTask;

import java.time.Duration;
@Singleton
public class InterestService implements CronTask {

    @Inject
    AccountManager accountManager;

    Duration interval = Duration.ofSeconds(5);

    private void calculateInterest(SavingBankAccount account) {
        System.out.println("------------------------------");
        System.out.println(account.getBalance());
        account.setBalance(account.getBalance() * (1 + account.interestRate));
         System.out.println(account.getBalance());
        System.out.println("------------------------------");
    }

    @Override
    public void doSomething() {
        for(BaseAccount acc : accountManager.getAccounts()){
            if(acc instanceof SavingBankAccount){
                calculateInterest((SavingBankAccount)acc);
            }
        }
    }

    @Override
    public Duration getInterval() {
        return interval;
    }

    @Override
    @Inject
    public void assingToService(CronService cronService) {
        cronService.addCronTask(this);
    }

}
