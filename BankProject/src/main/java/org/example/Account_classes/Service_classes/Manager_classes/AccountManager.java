package org.example.Account_classes.Service_classes.Manager_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Account_classes.Data_classes.Core.BankAccountWithCard;
import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Card_classes.Data_classes.BasePaymentCard;

import java.util.*;
@Singleton
public class AccountManager {

    private List<BaseAccount> accounts;
    @Inject
    public AccountManager() {
        accounts = new ArrayList<>();
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

    public BaseAccount findAccountByNumber(String accountNumber) {
        for (BaseAccount a : accounts) {
            if (a.getAccountNumber().equals(accountNumber)) {
                return a;
            }
        }
        return null;
    }
}

