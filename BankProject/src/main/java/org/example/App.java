package org.example;

import org.example.AccountOwner_classes.Data_classes.AdultAccountOwner;
import org.example.Account_classes.Data_classes.BankAccount;
import org.example.Card_classes.Data_classes.BasePaymentCard;

public class App {
    public static void Run(){
        Container container = new Container();

        AdultAccountOwner owner = container.ownerFactory.createAdultAccountOwner("Janek", "Rubeš");
        BankAccount bankAccount = container.bankAccountFactory.createBankAccount(1000, owner);
        BasePaymentCard card = container.paymentCardFactory.createBasePaymentCard(owner.getFirstName() + " " + owner.getLastName());

        bankAccount.addCard(card);

        container.accountOperationManager.processCardTransaction(card, 1000);
        container.accountOperationManager.processNormalTransaction(bankAccount, -3000);
    }
}
