package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes;

import com.google.inject.Singleton;
import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Helper_classes.Other.Logger.Interfaces.Logger;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;
@Singleton
public class WithdrawService {

    public boolean withdraw(BaseAccount account, double amount, PaymentValidator validator) {
        if (!validator.canWithdraw(account, amount)) {
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        return true;
    }
}
