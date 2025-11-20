package org.example.Account_classes.Transaction_classes.Serialization_classes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Singleton;

import java.util.List;
@Singleton
public class JsonTransactionSerializer implements TransactionSerializer {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String serialize(List<SerializedTransaction> transactions) {
        try {
            return mapper.writeValueAsString(transactions);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error while serializing transactions to JSON", e);
        }
    }
}
