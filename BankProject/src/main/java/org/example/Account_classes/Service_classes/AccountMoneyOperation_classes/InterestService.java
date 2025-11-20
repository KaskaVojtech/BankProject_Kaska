package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Helper_classes.Other.Logger.ConsoleLogger;
import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Data_classes.SavingBankAccount;
import org.example.Account_classes.Service_classes.Manager_classes.AccountManager;
import org.example.Helper_classes.Other.Cron_classes.CronTask;
import org.example.Account_classes.Transaction_classes.TransactionManager;
import org.example.Account_classes.Transaction_classes.TransactionType;

import java.time.Duration;
@Singleton
public class InterestService implements CronTask {

    @Inject
    private AccountManager accountManager;

    @Inject
    private TransactionManager transactionManager;

    @Inject
    private ConsoleLogger logger;

    private final Duration interval = Duration.ofSeconds(5);

    private void calculateInterest(SavingBankAccount account) {

        double currentBalance = account.getBalance();
        double interestRate = account.interestRate;
        double interestAmount = currentBalance * (interestRate / 100);

        logger.log("------------------------------");
        logger.log("Calculating interest for account: " + account.getAccountNumber());
        logger.log("Balance before interest: " + currentBalance);
        logger.log("Interest amount: " + interestAmount);

        try {
            transactionManager.processNormalTransaction(
                    TransactionType.DEPOSIT,
                    null,               // sender = žádný (úrok není od osoby)
                    account,            // receiver = účet ke kterému to patří
                    interestAmount
            );
        } catch (Exception e) {
            logger.log("Interest deposit failed: " + e.getMessage());
            return;
        }

        logger.log("Balance after interest: " + account.getBalance());
        logger.log("------------------------------");
    }

    @Override
    public void doSomething() {
        for (BaseAccount acc : accountManager.getAccounts()) {
            if (acc instanceof SavingBankAccount savingAcc) {
                calculateInterest(savingAcc);
            }
        }
    }

    @Override
    public Duration getInterval() {
        return interval;
    }

}
