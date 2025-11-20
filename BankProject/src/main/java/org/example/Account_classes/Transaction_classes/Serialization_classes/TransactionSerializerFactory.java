package org.example.Account_classes.Transaction_classes.Serialization_classes;

import com.google.inject.Singleton;

@Singleton

public class TransactionSerializerFactory {

    public TransactionSerializer createSerializer(SerializerType type) {
        return switch (type) {
            case JSON -> new JsonTransactionSerializer();
        };
    }

    public enum SerializerType { JSON }
}

