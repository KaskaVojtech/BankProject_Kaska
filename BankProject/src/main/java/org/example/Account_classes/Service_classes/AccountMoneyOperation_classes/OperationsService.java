package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.DepositService;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.TransferService;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.WithdrawService;
import org.example.Helper_classes.Other.Logger.Interfaces.Logger;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;
@Singleton
public class OperationsService {
    @Inject
    DepositService depositService;
    @Inject
    WithdrawService withdrawService;
    @Inject
    TransferService transferService;

    public OperationsService(DepositService depositService, WithdrawService withdrawService, TransferService transferService) {
        this.depositService = depositService;
        this.withdrawService = withdrawService;
        this.transferService = transferService;
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
