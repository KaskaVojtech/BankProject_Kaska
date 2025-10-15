package org.example;

import org.example.Accounts.AdultBankAccount;
import org.example.AccountsOwners.AdultAccountOwner;
import org.example.Factories.AccountOwnerFactory;
import org.example.Factories.BankAccountFactory;
import org.example.Factories.PaymentCardFactory;
import org.example.Services.AccountManager;
import org.example.Services.AccountOperationService;
import org.example.Services.AccountValidator;
import org.example.Services.Generators.*;
import org.example.cards.BasePaymentCard;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        IDGenerator IDGenerator = new IDGenerator();
        FourDigitsGenerator FourDigitsGenerator = new FourDigitsGenerator();
        MonthGenerator MonthGenerator = new MonthGenerator();
        YearGenerator YearGenerator = new YearGenerator();
        CardNumberGenerator CardNumberGenerator = new CardNumberGenerator();

        AccountManager manager = new AccountManager();
        AccountValidator validator = new AccountValidator();
        AccountOperationService service = new AccountOperationService(validator);

        AccountOwnerFactory ownerFactory = new AccountOwnerFactory();
        PaymentCardFactory paymentCardFactory = new PaymentCardFactory(IDGenerator,FourDigitsGenerator, YearGenerator, CardNumberGenerator, MonthGenerator);
        BankAccountFactory bankAccountFactory = new BankAccountFactory(manager);

        //------------------------------------------------------------------------------------

        AdultAccountOwner ao = ownerFactory.createAdultAccountOwner("Janek", "Rubeš");
        AdultBankAccount ab = bankAccountFactory.createAdultBankAccount(1000, ao);
        BasePaymentCard c = paymentCardFactory.createBasePaymentCard(ao.getFirstName() + " " + ao.getLastName());

        ab.addCard(c);

        service.processCardTransaction(manager, c, 500);

        System.out.println("Nový zůstatek: " + ab.getBalance());

    }
}