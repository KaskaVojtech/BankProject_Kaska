package org.example.Account_classes.Service_classes.Manager_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.OperationsService;
import org.example.Helper_classes.Validator_classes.Enums.ValidatorType;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;
import org.example.Helper_classes.Validator_classes.ValidatorRegistry;
import org.example.Card_classes.Data_classes.BasePaymentCard;
@Singleton
public class AccountOperationManager {
    @Inject
    private  ValidatorRegistry validatorRegistry;
    @Inject
    private  AccountManager accountManager;
    @Inject
    private  OperationsService operationsService;

    @Inject
    public AccountOperationManager(ValidatorRegistry validatorRegistry, AccountManager accountManager, OperationsService operationsService) {
        this.validatorRegistry = validatorRegistry;
        this.accountManager = accountManager;
        this.operationsService = operationsService;
    }

    public boolean processCardTransaction(BasePaymentCard card, double amount) {
        BaseAccount account = accountManager.findAccountByCard(card);

        PaymentValidator validator = validatorRegistry.get(ValidatorType.CARD);
        return processTransaction(account, amount, validator);
    }
    public boolean processNormalTransaction(BaseAccount account, double amount) {
        PaymentValidator validator = validatorRegistry.get(ValidatorType.NORMAL);
        return processTransaction(account, amount, validator);
    }

    private boolean processTransaction(BaseAccount account, double amount, PaymentValidator validator) {
        boolean success;

        if (amount >= 0) {
            success = operationsService.deposit(account, amount, validator);
        } else {
            success = operationsService.withdraw(account, Math.abs(amount), validator);
        }

        return success;
    }


}

