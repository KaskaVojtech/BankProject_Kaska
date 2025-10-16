package org.example.Account_classes.Data_classes.Core;

import org.example.AccountOwner_classes.Data_classes.Core_classes.BaseAccountOwner;
import org.example.Card_classes.Data_classes.BasePaymentCard;

import java.util.ArrayList;
import java.util.List;

public class BankAccountWithCard extends BaseAccount {

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
