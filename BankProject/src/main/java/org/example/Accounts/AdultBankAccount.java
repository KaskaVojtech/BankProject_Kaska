package org.example.Accounts;

import org.example.AccountsOwners.BaseAccountOwner;

public class AdultBankAccount extends BaseAccountOwner {
    public AdultBankAccount(String uuid, BaseAccountOwner human) {
        super(uuid, human.getFirstName(), human.getLastName());
    }
}
