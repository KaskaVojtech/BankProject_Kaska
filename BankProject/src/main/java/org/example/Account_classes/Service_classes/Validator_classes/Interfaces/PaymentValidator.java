package org.example.Account_classes.Service_classes.Validator_classes.Interfaces;

import org.example.Account_classes.Data_classes.Core.BaseAccount;

public interface PaymentValidator {
    boolean canDeposit(BaseAccount account, double amount);
    boolean canWithdraw(BaseAccount account, double amount);
    boolean canTransfer(BaseAccount from, BaseAccount to, double amount);
}