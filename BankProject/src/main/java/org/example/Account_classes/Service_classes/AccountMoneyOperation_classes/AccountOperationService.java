package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Service_classes.AccountManager;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.DepositService;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.WithdrawService;
import org.example.Helper_classes.Other.Logger.Interfaces.Logger;
import org.example.Helper_classes.Validator_classes.Enums.ValidatorType;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;
import org.example.Helper_classes.Validator_classes.ValidatorRegistry;
import org.example.Card_classes.Data_classes.BasePaymentCard;

public class AccountOperationService {

    private final ValidatorRegistry validatorRegistry;
    private final AccountManager accountManager;
    private final Logger logger;

    public AccountOperationService(AccountManager accountManager, ValidatorRegistry validatorRegistry, Logger logger) {
        this.accountManager = accountManager;
        this.validatorRegistry = validatorRegistry;
        this.logger = logger;
    }

    public boolean processCardTransaction(BasePaymentCard card, double amount) {
        logger.log("Card transaction:");
        BaseAccount account = accountManager.findAccountByCard(card);

        PaymentValidator validator = validatorRegistry.get(ValidatorType.CARD);
        return proccessTransaction(account, amount, validator);
    }
    public boolean processNormalTransaction(BaseAccount account, double amount) {
        logger.log("Normal transaction:");
        PaymentValidator validator = validatorRegistry.get(ValidatorType.NORMAL);
        return proccessTransaction(account, amount, validator);
    }

    private boolean proccessTransaction(BaseAccount account, double amount, PaymentValidator validator) {
        DepositService depositService = new DepositService(validator, logger);
        WithdrawService withdrawService = new WithdrawService(validator, logger);

        boolean success;
        if (amount >= 0) {
            success = depositService.deposit(account, amount);
        } else {
            success = withdrawService.withdraw(account, Math.abs(amount));
        }

        return success;
    }


}

