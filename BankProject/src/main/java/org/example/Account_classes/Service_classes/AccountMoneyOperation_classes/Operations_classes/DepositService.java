package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Helper_classes.Other.Logger.Interfaces.Logger;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;

public class DepositService {

    public DepositService() {
    }

    public boolean deposit(BaseAccount account, double amount, PaymentValidator validator) {
        if (!validator.canDeposit(account, amount)) {
            return false;
        }
        account.setBalance(account.getBalance() + amount);
        return true;
    }
}
