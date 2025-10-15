package org.example.Accounts;

import org.example.AccountsOwners.BaseAccountOwner;
import org.example.cards.BasePaymentCard;

import java.util.ArrayList;
import java.util.List;

public class BankAccountWithCard extends BaseAccount{

    private List<BasePaymentCard> cards;

    public BankAccountWithCard(String uuid, double balance, String accountNumber, BaseAccountOwner owner) {
        super(uuid, balance, accountNumber, owner);

        cards = new ArrayList<BasePaymentCard>();
    }

    public List<BasePaymentCard> getCards() {
        return cards;
    }

    public void addCard(BasePaymentCard card) {
        cards.add(card);
    }
}
