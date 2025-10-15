package org.example.Factories;

import org.example.AccountsOwners.BaseAccountOwner;
import org.example.Serialization.Objects.SerializedAccountOwner;
import org.example.Services.Generators.IDGenerator;

public class AccountOwnerSerializedFactory {

    IDGenerator IDGenerator = new IDGenerator();

    public AccountOwnerSerializedFactory() {
    }

    public SerializedAccountOwner createSerializedAccountOwner(BaseAccountOwner baseAccountOwner) {
        return new SerializedAccountOwner(baseAccountOwner);
    }
}
