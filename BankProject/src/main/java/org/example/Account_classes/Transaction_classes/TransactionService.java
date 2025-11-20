package org.example.Account_classes.Transaction_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;

public interface TransactionService {
    Transaction process(BaseAccount sender,
                        BaseAccount receiver,
                        double amount,
                        TransactionMethod method);
}

