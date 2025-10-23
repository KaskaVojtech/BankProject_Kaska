package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.DepositService;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.TransferService;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.WithdrawService;
import org.example.Helper_classes.Other.Logger.Interfaces.Logger;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;

public class OperationsService {
    DepositService depositService;
    WithdrawService withdrawService;
    TransferService transferService;

    public OperationsService(DepositService depositService, TransferService transferService, WithdrawService withdrawService) {
        this.depositService = depositService;
        this.transferService = transferService;
        this.withdrawService = withdrawService;
    }

    public boolean deposit(BaseAccount acc, double amount, PaymentValidator validator) {
        return depositService.deposit(acc, amount, validator);
    }

    public boolean withdraw(BaseAccount acc, double amount, PaymentValidator validator) {
        return withdrawService.withdraw(acc, amount, validator);
    }

    public boolean transfer(BaseAccount from, BaseAccount to, double amount, PaymentValidator validator) {
        return transferService.transfer(from, to, amount, validator);
    }
}
