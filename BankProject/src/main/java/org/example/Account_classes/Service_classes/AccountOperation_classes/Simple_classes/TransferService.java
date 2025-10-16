package org.example.Account_classes.Service_classes.AccountOperation_classes.Simple_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Service_classes.Validator_classes.Interfaces.PaymentValidator;

public class TransferService {
    private final PaymentValidator validator;

    public TransferService(PaymentValidator validator) {
        this.validator = validator;
    }

    public boolean transfer(BaseAccount from, BaseAccount to, double amount) {
        if (!validator.canTransfer(from, to, amount)) return false;
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        return true;
    }
}
