package org.example.Factories;

import org.example.Serialization.Objects.SerializedAccountOwner;
import org.example.Services.UniqueNumberGenerator;

public class AccountOwnerSerializedFactory {

    UniqueNumberGenerator uniqueNumberGenerator = new UniqueNumberGenerator();

    public AccountOwnerSerializedFactory(UniqueNumberGenerator uniqueNumberGenerator) {
        this.uniqueNumberGenerator = uniqueNumberGenerator;
    }

    public SerializedAccountOwner createSerializedAccountOwner(String firstName, String lastName) {
        return new SerializedAccountOwner(uniqueNumberGenerator.makeID_UUID(), firstName, lastName);
    }
}
