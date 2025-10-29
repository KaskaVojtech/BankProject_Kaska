package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes;

import com.google.inject.Singleton;
import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Helper_classes.Other.Logger.Interfaces.Logger;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;
@Singleton
public class TransferService {


    public boolean transfer(BaseAccount from, BaseAccount to, double amount, PaymentValidator validator) {
        if (!validator.canTransfer(from, to, amount)) return false;
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        return true;
    }
}
