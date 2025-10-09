package org.example.Factories;

import org.example.AccountsOwners.BaseAccountOwner;
import org.example.Serialization.Objects.SerializedAccountOwner;
import org.example.Services.UniqueNumberGenerator;

public class AccountOwnerSerializedFactory {

    UniqueNumberGenerator uniqueNumberGenerator = new UniqueNumberGenerator();

    public AccountOwnerSerializedFactory() {
    }

    public SerializedAccountOwner createSerializedAccountOwner(BaseAccountOwner baseAccountOwner) {
        return new SerializedAccountOwner(baseAccountOwner);
    }
}
