package org.example.people;

import org.example.Accounts.BaseAccount;

public class AccountOwner extends BaseHuman {

    BaseAccount baseAccount;

    public AccountOwner(String uuid, String firstName, String lastName, BaseAccount account) {
        super(uuid, firstName, lastName);
        this.baseAccount = account;
    }
}
