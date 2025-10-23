package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Service_classes.AccountManager;
import org.example.Card_classes.Data_classes.BasePaymentCard;

public class CardTransactionService {

    private final AccountManager accountManager;
    private final DepositService depositService;
    private final WithdrawService withdrawService;

    public CardTransactionService(AccountManager accountManager,
                                  DepositService depositService,
                                  WithdrawService withdrawService) {
        this.accountManager = accountManager;
        this.depositService = depositService;
        this.withdrawService = withdrawService;
    }

    public boolean processCardTransaction(BasePaymentCard card, double amount) {
        BaseAccount account = accountManager.findAccountByCard(card);
        if (account == null) return false;

        if (amount >= 0) {
            return depositService.deposit(account, amount);
        } else {
            return withdrawService.withdraw(account, Math.abs(amount));
        }
    }
}

