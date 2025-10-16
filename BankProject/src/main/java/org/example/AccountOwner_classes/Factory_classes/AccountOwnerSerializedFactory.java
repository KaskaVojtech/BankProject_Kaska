package org.example.AccountOwner_classes.Factory_classes;

import org.example.AccountOwner_classes.Data_classes.Core_classes.BaseAccountOwner;
import org.example.AccountOwner_classes.Serialization_classes.Data_classes.SerializedAccountOwner;
import org.example.Helper_classes.Generation_classes.IDGenerator;

public class AccountOwnerSerializedFactory {

    IDGenerator IDGenerator = new IDGenerator();

    public AccountOwnerSerializedFactory() {
    }

    public SerializedAccountOwner createSerializedAccountOwner(BaseAccountOwner baseAccountOwner) {
        return new SerializedAccountOwner(baseAccountOwner);
    }
}
