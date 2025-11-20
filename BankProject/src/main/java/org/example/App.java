package org.example;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.AccountOwner_classes.Data_classes.AdultAccountOwner;
import org.example.AccountOwner_classes.Factory_classes.AccountOwnerFactory;
import org.example.Account_classes.Data_classes.Core.BankAccountWithCard;
import org.example.Account_classes.Factories.BankAccountFactory;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.InterestService;
import org.example.Card_classes.Data_classes.BasePaymentCard;
import org.example.Card_classes.Factory_classes.PaymentCardFactory;
import org.example.Helper_classes.Other.Cron_classes.CronService;
import org.example.Account_classes.Transaction_classes.TransactionHistoryService;
import org.example.Account_classes.Transaction_classes.TransactionManager;
import org.example.Account_classes.Transaction_classes.TransactionType;

@Singleton
public class App {
    @Inject
    AccountOwnerFactory accountOwnerFactory;

    @Inject
    BankAccountFactory bankAccountFactory;

    @Inject
    PaymentCardFactory paymentCardFactory;


    @Inject
    InterestService service;

    @Inject
    CronService cronService;

    @Inject
    TransactionManager transactionManager;

    @Inject
    InterestService interestService;

    @Inject
    TransactionHistoryService transactionHistoryService;

    public void run() throws InterruptedException {
        cronService.add(interestService);
        cronService.add(transactionHistoryService);
        cronService.start();

        AdultAccountOwner owner = accountOwnerFactory.createAdultAccountOwner("Janek", "Rubeš");
        BasePaymentCard card = paymentCardFactory.createBasePaymentCard(owner.getFirstName() + " " + owner.getLastName());
        BankAccountWithCard bankAccount = bankAccountFactory.createBankAccountWithCard(1000, owner, card);

        transactionManager.processCardTransaction(TransactionType.DEPOSIT, card, bankAccount, 2000);

        Thread.sleep(10000);

    }
}
