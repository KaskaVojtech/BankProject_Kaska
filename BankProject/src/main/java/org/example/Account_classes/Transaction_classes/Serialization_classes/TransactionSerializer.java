package org.example.Account_classes.Transaction_classes.Serialization_classes;

import java.util.List;

public interface TransactionSerializer {

    String serialize(List<SerializedTransaction> transactions);
}
