package org.example.Helper_classes.Validator_classes.ValidatorType_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;

public class NormalPaymentValidator implements PaymentValidator {

    private double threshold = 10_000;

    @Override
    public boolean canDeposit(BaseAccount account, double amount) {
        if (amount > threshold) return false;
        return amount > 0;
    }

    @Override
    public boolean canWithdraw(BaseAccount account, double amount) {
        if (amount <= 0) return false;
        return account.getBalance() >= amount;
    }

    @Override
    public boolean canTransfer(BaseAccount from, BaseAccount to, double amount) {
        if (from == null || to == null) return false;
        if (amount <= 0) return false;
        return from.getBalance() >= amount;
    }
}

