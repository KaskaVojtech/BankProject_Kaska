package org.example;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.AccountOwner_classes.Data_classes.AdultAccountOwner;
import org.example.AccountOwner_classes.Factory_classes.AccountOwnerFactory;
import org.example.Account_classes.Data_classes.BankAccount;
import org.example.Account_classes.Data_classes.Core.BankAccountWithCard;
import org.example.Account_classes.Factories.BankAccountFactory;
import org.example.Account_classes.Service_classes.Manager_classes.AccountOperationManager;
import org.example.Card_classes.Data_classes.BasePaymentCard;
import org.example.Card_classes.Factory_classes.PaymentCardFactory;

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

    public void run(){
        AdultAccountOwner owner = accountOwnerFactory.createAdultAccountOwner("Janek", "Rubeš");
        BasePaymentCard card = paymentCardFactory.createBasePaymentCard(owner.getFirstName() + " " + owner.getLastName());
        BankAccountWithCard bankAccount = bankAccountFactory.createBankAccountWithCard(1000, owner, card);

        accountOperationManager.processCardTransaction(card, 1000);
        accountOperationManager.processNormalTransaction(bankAccount, -3000);
    }
}
