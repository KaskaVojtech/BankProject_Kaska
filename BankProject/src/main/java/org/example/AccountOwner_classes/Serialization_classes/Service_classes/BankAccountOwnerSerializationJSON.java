package org.example.AccountOwner_classes.Serialization_classes.Service_classes;

import com.google.gson.Gson;
import org.example.AccountOwner_classes.Data_classes.Core_classes.BaseAccountOwner;
import org.example.AccountOwner_classes.Factory_classes.AccountOwnerSerializedFactory;
import org.example.AccountOwner_classes.Serialization_classes.Interfaces.Serialization;
import org.example.AccountOwner_classes.Serialization_classes.Data_classes.SerializedAccountOwner;

public class BankAccountOwnerSerializationJSON implements Serialization {

    AccountOwnerSerializedFactory accountOwnerSerializedFactory;
    Gson gson;

    public BankAccountOwnerSerializationJSON(AccountOwnerSerializedFactory accountOwnerSerializedFactory, Gson gson) {
        this.accountOwnerSerializedFactory = accountOwnerSerializedFactory;
        this.gson = gson;
    }

    @Override
    public String serialize(Object object) {
        if(!(object instanceof BaseAccountOwner)){
            throw new ClassCastException("Object is not BaseAccountOwner");
        }

        BaseAccountOwner owner = (BaseAccountOwner) object;
        SerializedAccountOwner serializedAccountOwner =
                accountOwnerSerializedFactory.createSerializedAccountOwner(owner);
        String json = gson.toJson(serializedAccountOwner);
        return json;

    }

    @Override
    public SerializedAccountOwner deserialize(String string) {
        SerializedAccountOwner serializedAccountOwner = gson.fromJson(string, SerializedAccountOwner.class);
        return serializedAccountOwner;
    }


}
