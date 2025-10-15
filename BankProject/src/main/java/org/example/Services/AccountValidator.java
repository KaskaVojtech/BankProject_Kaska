package org.example.Services;

import org.example.Accounts.BaseAccount;

public class AccountValidator {

    public boolean canDeposit(BaseAccount account, double amount) {
        return amount > 0;
    }

    public boolean canWithdraw(BaseAccount account, double amount) {
        if (amount <= 0) return false;
        return account.getBalance() >= amount;
    }

    public boolean canTransfer(BaseAccount from, BaseAccount to, double amount) {
        if (from == null || to == null) return false;
        if (amount <= 0) return false;
        return from.getBalance() >= amount;
    }
}
