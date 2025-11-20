package org.example.Account_classes.Transaction_classes;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.Helper_classes.Other.Cron_classes.CronTask;
import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Service_classes.Manager_classes.AccountManager;
import org.example.Account_classes.Transaction_classes.Serialization_classes.SerializedTransaction;
import org.example.Account_classes.Transaction_classes.Serialization_classes.TransactionSerializer;
import org.example.Account_classes.Transaction_classes.Serialization_classes.TransactionSerializerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Singleton
public class TransactionHistoryService implements CronTask {

    @Inject
    AccountManager accountManager;

    @Inject
    TransactionSerializerFactory serializerFactory;

    @Override
    public void doSomething() {
        for (BaseAccount acc : accountManager.getAccounts()) {
            SaveAccountHistory(acc);
            acc.transactions.clear();
        }
    }

    @Override
    public Duration getInterval() {
        return Duration.ofSeconds(5);
    }


    private void SaveAccountHistory(BaseAccount acc) {
        List<Transaction> transactions = acc.transactions;

        if (transactions.isEmpty()) {
            return;
        }

        List<SerializedTransaction> serializedList =
                TransactionMapper.mapList(transactions);

        TransactionSerializer serializer =
                serializerFactory.createSerializer(TransactionSerializerFactory.SerializerType.JSON);

        String json = serializer.serialize(serializedList);

        Path outputPath = Path.of("history", acc.getAccountNumber() + "-" + LocalDate.now() +  "-history.json");

        try {
            Files.createDirectories(outputPath.getParent());
            Files.writeString(outputPath, json);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write transaction history for account: " + acc.getAccountNumber(), e);
        }

    }
}
