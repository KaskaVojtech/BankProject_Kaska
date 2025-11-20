package org.example.Account_classes.Transaction_classes;

import com.google.inject.Singleton;
import org.example.Account_classes.Transaction_classes.Serialization_classes.SerializedTransaction;

import java.util.List;
@Singleton
public class TransactionMapper {

    public static SerializedTransaction map(Transaction t) {
        return new SerializedTransaction(
                t.date.toString(),
                t.sender.getAccountNumber(),
                t.reciever.getAccountNumber(),
                t.amount,
                t.transactionType.name(),
                t.transactionMethod.name()
        );
    }

    public static List<SerializedTransaction> mapList(List<Transaction> list) {
        return list.stream()
                .map(TransactionMapper::map)
                .toList();
    }
}

