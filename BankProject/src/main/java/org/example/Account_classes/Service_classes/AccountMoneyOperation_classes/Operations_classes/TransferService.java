package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Helper_classes.Other.Logger.Interfaces.Logger;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;

public class TransferService {

    final Logger logger;

    public TransferService(Logger logger) {
        this.logger = logger;
    }

    public boolean transfer(BaseAccount from, BaseAccount to, double amount, PaymentValidator validator) {
        if (!validator.canTransfer(from, to, amount)) return false;
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        return true;
    }
}
