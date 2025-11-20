package org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Transaction_classes.*;

@Singleton
public class TransferTransactionService implements TransactionService {

    @Inject
    private TransactionFactory factory;


    @Override
    public Transaction process(BaseAccount sender,
                               BaseAccount receiver,
                               double amount,
                               TransactionMethod method) {

        if (sender.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds.");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        return factory.createTransaction(
                sender, receiver, amount,
                TransactionType.TRANSFER, method
        );
    }
}

