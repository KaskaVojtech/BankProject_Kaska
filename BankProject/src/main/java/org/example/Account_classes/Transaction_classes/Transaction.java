package org.example.Account_classes.Transaction_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;

import java.time.LocalDate;

public class Transaction {
    public LocalDate date;
    public BaseAccount sender;
    public BaseAccount reciever;
    public double amount;
    public TransactionType transactionType;
    public TransactionMethod transactionMethod;
    public Transaction(LocalDate date, BaseAccount sender, BaseAccount reciever, double amount, TransactionType transactionType, TransactionMethod transactionMethod)
    {
        this.date = date;
        this.sender = sender;
        this.reciever = reciever;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionMethod = transactionMethod;
    }
}
