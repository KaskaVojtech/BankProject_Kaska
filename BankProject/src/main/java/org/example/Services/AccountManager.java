package org.example.Services;

import org.example.Accounts.BankAccountWithCard;
import org.example.Accounts.BaseAccount;
import org.example.cards.BasePaymentCard;

import java.util.*;

public class AccountManager {

    private final List<BaseAccount> accounts;

    public AccountManager() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BaseAccount account) {
        accounts.add(account);
    }

    public List<BaseAccount> getAccounts() {
        return accounts;
    }

    public BaseAccount findAccountByCard(BasePaymentCard card) {
        for (BaseAccount acc : accounts) {
            if (acc instanceof BankAccountWithCard bankAcc) {
                for (BasePaymentCard c : bankAcc.getCards()) {
                    if (c.getCardNumber().equals(card.getCardNumber())) {
                        return acc;
                    }
                }
            }
        }
        return null;
    }

}

