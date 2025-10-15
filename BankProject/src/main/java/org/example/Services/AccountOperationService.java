package org.example.Services;

import org.example.Accounts.BaseAccount;
import org.example.cards.BasePaymentCard;

public class AccountOperationService {

    private final AccountValidator validator;

    public AccountOperationService(AccountValidator validator) {
        this.validator = validator;
    }

    public boolean deposit(BaseAccount account, double amount) {
        if (!validator.canDeposit(account, amount)) return false;
        account.setBalance(account.getBalance() + amount);
        return true;
    }

    public boolean withdraw(BaseAccount account, double amount) {
        if (!validator.canWithdraw(account, amount)) return false;
        account.setBalance(account.getBalance() - amount);
        return true;
    }

    public boolean transfer(BaseAccount from, BaseAccount to, double amount) {
        if (!validator.canTransfer(from, to, amount)) return false;
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        return true;
    }


    public boolean processCardTransaction(AccountManager manager, BasePaymentCard card, double amount) {
        BaseAccount account = manager.findAccountByCard(card);
        if (account == null) return false;

        if (amount >= 0) {
            return deposit(account, amount);
        } else {
            return withdraw(account, Math.abs(amount));
        }
    }
}
