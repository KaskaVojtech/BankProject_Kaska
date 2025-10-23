package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Helper_classes.Other.Logger.Interfaces.Logger;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;

public class WithdrawService {
    private final PaymentValidator validator;
    private final Logger logger;

    public WithdrawService(PaymentValidator validator, Logger logger) {
        this.validator = validator;
        this.logger = logger;
    }

    public boolean withdraw(BaseAccount account, double amount) {
        if (!validator.canWithdraw(account, amount)) {
            logger.log("Výběr zamítnut z účtu " + account.getAccountNumber() + " částka: " + amount);
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        logger.log("Výběr: " + amount + " Kč z účtu " + account.getAccountNumber() + " | nový zůstatek: " + account.getBalance());
        return true;
    }
}
