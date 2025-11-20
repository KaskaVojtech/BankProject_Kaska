package org.example.Account_classes.Transaction_classes;

import com.google.inject.Singleton;
import org.example.Account_classes.Data_classes.Core.BaseAccount;

import java.time.LocalDate;

@Singleton
public class TransactionFactory
{
    public Transaction createTransaction(BaseAccount sender, BaseAccount reciever, double amount, TransactionType type, TransactionMethod transactionMethod)
    {
        return new Transaction(LocalDate.now(),sender,reciever,amount, type, transactionMethod);
    }
}
