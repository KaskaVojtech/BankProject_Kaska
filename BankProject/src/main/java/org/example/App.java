package org.example;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.AccountOwner_classes.Data_classes.AdultAccountOwner;
import org.example.AccountOwner_classes.Factory_classes.AccountOwnerFactory;
import org.example.Account_classes.Data_classes.BankAccount;
import org.example.Account_classes.Data_classes.Core.BankAccountWithCard;
import org.example.Account_classes.Data_classes.SavingBankAccount;
import org.example.Account_classes.Factories.BankAccountFactory;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.InterestService;
import org.example.Account_classes.Service_classes.Manager_classes.AccountOperationManager;
import org.example.Card_classes.Data_classes.BasePaymentCard;
import org.example.Card_classes.Factory_classes.PaymentCardFactory;
import org.example.Helper_classes.Other.Cron_classes.CronService;

import java.awt.*;

@Singleton
public class App {
    @Inject
    AccountOwnerFactory accountOwnerFactory;

    @Inject
    BankAccountFactory bankAccountFactory;

    @Inject
    PaymentCardFactory paymentCardFactory;

    @Inject
    AccountOperationManager accountOperationManager;

    @Inject
    InterestService service;

    @Inject
    CronService cronService;

    public void run() throws InterruptedException {
        cronService.start();

        AdultAccountOwner owner = accountOwnerFactory.createAdultAccountOwner("Janek", "Rubeš");
        BasePaymentCard card = paymentCardFactory.createBasePaymentCard(owner.getFirstName() + " " + owner.getLastName());
        BankAccountWithCard bankAccount = bankAccountFactory.createBankAccountWithCard(1000, owner, card);

        SavingBankAccount savingBankAccount = bankAccountFactory.createSavingBankAccount(1000,owner,0.5/12);

        accountOperationManager.processCardTransaction(card, 1000);
        accountOperationManager.processNormalTransaction(bankAccount, -3000);

        Thread.sleep(10000);

    }
}
