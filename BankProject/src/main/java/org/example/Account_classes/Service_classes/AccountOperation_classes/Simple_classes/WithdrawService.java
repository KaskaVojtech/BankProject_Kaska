package org.example.Account_classes.Service_classes.AccountOperation_classes.Simple_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Service_classes.Validator_classes.Interfaces.PaymentValidator;

public class WithdrawService {
    private final PaymentValidator validator;

    public WithdrawService(PaymentValidator validator) {
        this.validator = validator;
    }

    public boolean withdraw(BaseAccount account, double amount) {
        if (!validator.canWithdraw(account, amount)) return false;
        account.setBalance(account.getBalance() - amount);
        return true;
    }
}
