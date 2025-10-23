package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Service_classes.Validator_classes.Interfaces.PaymentValidator;
import org.example.Helper_classes.Other.Logger;

public class DepositService {
    private final PaymentValidator validator;
    private final Logger logger;

    public DepositService(PaymentValidator validator, Logger logger) {
        this.validator = validator;
        this.logger = logger;
    }

    public boolean deposit(BaseAccount account, double amount) {
        if (!validator.canDeposit(account, amount)) {
            logger.log("Vklad zamítnut na účet " + account.getAccountNumber() + " částka: " + amount);
            return false;
        }
        account.setBalance(account.getBalance() + amount);
        logger.log("Vklad: " + amount + " Kč na účet " + account.getAccountNumber() + " | nový zůstatek: " + account.getBalance());
        return true;
    }
}
