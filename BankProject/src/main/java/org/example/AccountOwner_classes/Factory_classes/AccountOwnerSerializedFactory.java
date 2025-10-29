package org.example.AccountOwner_classes.Factory_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.AccountOwner_classes.Data_classes.Core_classes.BaseAccountOwner;
import org.example.AccountOwner_classes.Serialization_classes.Data_classes.SerializedAccountOwner;
import org.example.Helper_classes.Generation_classes.IDGenerator;
@Singleton
public class AccountOwnerSerializedFactory {
    @Inject
    IDGenerator IDGenerator;

    public AccountOwnerSerializedFactory(IDGenerator IDGenerator) {
        this.IDGenerator = IDGenerator;
    }

    public SerializedAccountOwner createSerializedAccountOwner(BaseAccountOwner baseAccountOwner) {
        return new SerializedAccountOwner(baseAccountOwner);
    }
}
