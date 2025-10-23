package org.example.Helper_classes.Validator_classes.ValidatorType_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;

public class CardPaymentValidator implements PaymentValidator {

    private double cardLimit = 5_000;

    @Override
    public boolean canDeposit(BaseAccount account, double amount) {
        return amount > 0 && amount <= cardLimit;
    }

    @Override
    public boolean canWithdraw(BaseAccount account, double amount) {
        if (amount <= 0) return false;
        return account.getBalance() >= amount && amount <= cardLimit;
    }

    @Override
    public boolean canTransfer(BaseAccount from, BaseAccount to, double amount) {
        return false;
    }
}


