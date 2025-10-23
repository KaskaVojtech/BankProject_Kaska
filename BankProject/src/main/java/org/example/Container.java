package org.example;

import org.example.AccountOwner_classes.Factory_classes.AccountOwnerFactory;
import org.example.Account_classes.Factories.BankAccountFactory;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.OperationsService;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.DepositService;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.TransferService;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.WithdrawService;
import org.example.Account_classes.Service_classes.Manager_classes.AccountManager;
import org.example.Account_classes.Service_classes.Manager_classes.AccountOperationManager;
import org.example.Card_classes.Factory_classes.PaymentCardFactory;
import org.example.Helper_classes.Generation_classes.*;
import org.example.Helper_classes.Other.Logger.ConsoleLogger;
import org.example.Helper_classes.Validator_classes.ValidatorRegistry;
import org.example.Helper_classes.Validator_classes.ValidatorType_classes.CardPaymentValidator;
import org.example.Helper_classes.Validator_classes.ValidatorType_classes.NormalPaymentValidator;

public class Container {

    public IDGenerator idGenerator;
    public FourDigitsGenerator fourDigitsGenerator;
    public MonthGenerator monthGenerator;
    public YearGenerator yearGenerator;
    public CardNumberGenerator cardNumberGenerator;
    public ConsoleLogger consoleLogger;
    public AccountManager accountManager;
    public NormalPaymentValidator normalPaymentValidator;
    public CardPaymentValidator cardPaymentValidator;
    public ValidatorRegistry validatorRegistry;
    public DepositService depositService;
    public TransferService transferService;
    public WithdrawService withdrawService;
    public OperationsService operationsService;
    public AccountOperationManager accountOperationManager;
    public AccountOwnerFactory ownerFactory;
    public PaymentCardFactory paymentCardFactory;
    public BankAccountFactory bankAccountFactory;

    public Container() {

        IDGenerator idGenerator = new IDGenerator();
        FourDigitsGenerator fourDigitsGenerator = new FourDigitsGenerator();
        MonthGenerator monthGenerator = new MonthGenerator();
        YearGenerator yearGenerator = new YearGenerator();
        CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();

        consoleLogger = new ConsoleLogger();

        accountManager = new AccountManager();

        normalPaymentValidator = new NormalPaymentValidator(consoleLogger);
        cardPaymentValidator = new CardPaymentValidator(consoleLogger);
        validatorRegistry = new ValidatorRegistry(normalPaymentValidator, cardPaymentValidator);

        depositService = new DepositService();
        transferService = new TransferService();
        withdrawService = new WithdrawService();

        operationsService = new OperationsService(depositService, transferService, withdrawService);

        accountOperationManager =
                new AccountOperationManager(accountManager,validatorRegistry, operationsService);

        ownerFactory = new AccountOwnerFactory();
        paymentCardFactory = new PaymentCardFactory(
                idGenerator, fourDigitsGenerator, yearGenerator, cardNumberGenerator, monthGenerator
        );
        bankAccountFactory = new BankAccountFactory(accountManager);
    }

}
