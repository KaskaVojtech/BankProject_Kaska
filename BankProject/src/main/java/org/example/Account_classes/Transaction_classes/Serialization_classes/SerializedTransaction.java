package org.example.Account_classes.Transaction_classes.Serialization_classes;

public class SerializedTransaction {
    public String date;
    public String senderAccountNumber;
    public String receiverAccountNumber;
    public double amount;
    public String transactionType;
    public String transactionMethod;

    public SerializedTransaction(String date,
                                 String senderAccountNumber,
                                 String receiverAccountNumber,
                                 double amount,
                                 String transactionType,
                                 String transactionMethod) {
        this.date = date;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionMethod = transactionMethod;
    }
}

