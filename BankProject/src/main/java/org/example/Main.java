package org.example;

import org.example.Account_classes.Data_classes.BankAccount;
import org.example.AccountOwner_classes.Data_classes.AdultAccountOwner;
import org.example.AccountOwner_classes.Factory_classes.AccountOwnerFactory;
import org.example.Account_classes.Factories.BankAccountFactory;
import org.example.Account_classes.Service_classes.AccountOperation_classes.AccountOperationService;
import org.example.Account_classes.Service_classes.AccountOperation_classes.Simple_classes.CardTransactionService;
import org.example.Account_classes.Service_classes.AccountOperation_classes.Simple_classes.DepositService;
import org.example.Account_classes.Service_classes.AccountOperation_classes.Simple_classes.TransferService;
import org.example.Account_classes.Service_classes.AccountOperation_classes.Simple_classes.WithdrawService;
import org.example.Account_classes.Service_classes.Validator_classes.Enums.ValidatorType;
import org.example.Account_classes.Service_classes.Validator_classes.Interfaces.PaymentValidator;
import org.example.Account_classes.Service_classes.Validator_classes.ValidatorRegistry;
import org.example.Card_classes.Factory_classes.PaymentCardFactory;
import org.example.Account_classes.Service_classes.AccountManager;
import org.example.Card_classes.Data_classes.BasePaymentCard;
import org.example.Helper_classes.Generation_classes.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        IDGenerator idGenerator = new IDGenerator();
        FourDigitsGenerator fourDigitsGenerator = new FourDigitsGenerator();
        MonthGenerator monthGenerator = new MonthGenerator();
        YearGenerator yearGenerator = new YearGenerator();
        CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();

        AccountManager accountManager = new AccountManager();

        ValidatorRegistry validatorRegistry = new ValidatorRegistry();

        PaymentValidator normalValidator = validatorRegistry.get(ValidatorType.NORMAL);
        PaymentValidator cardValidator = validatorRegistry.get(ValidatorType.CARD);

        DepositService depositService = new DepositService(normalValidator);
        WithdrawService withdrawService = new WithdrawService(normalValidator);
        TransferService transferService = new TransferService(normalValidator);

        CardTransactionService cardTransactionService =
                new CardTransactionService(accountManager,
                        new DepositService(cardValidator),
                        new WithdrawService(cardValidator));

        AccountOperationService accountOperationService =
                new AccountOperationService(accountManager,validatorRegistry);

        AccountOwnerFactory ownerFactory = new AccountOwnerFactory();
        PaymentCardFactory paymentCardFactory = new PaymentCardFactory(
                idGenerator, fourDigitsGenerator, yearGenerator, cardNumberGenerator, monthGenerator
        );
        BankAccountFactory bankAccountFactory = new BankAccountFactory(accountManager);

//--------------------------------------------------------------------------------------------------------

        AdultAccountOwner owner = ownerFactory.createAdultAccountOwner("Janek", "Rubeš");
        BankAccount bankAccount = bankAccountFactory.createBankAccount(1000, owner);
        BasePaymentCard card = paymentCardFactory.createBasePaymentCard(owner.getFirstName() + " " + owner.getLastName());
        bankAccount.addCard(card);
        accountOperationService.processCardTransaction(card, 500);

        System.out.println("Nový zůstatek: " + bankAccount.getBalance());
    }
}
