package org.example.Serialization;

import com.google.gson.Gson;
import org.example.AccountsOwners.BaseAccountOwner;
import org.example.Factories.AccountOwnerSerializedFactory;
import org.example.Serialization.Objects.SerializedAccountOwner;

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
                accountOwnerSerializedFactory.createSerializedAccountOwner(
                        owner.getFirstName(),
                        owner.getLastName()
                );
        String json = gson.toJson(serializedAccountOwner);
        return json;

    }

    @Override
    public SerializedAccountOwner deserialize(String string) {
        SerializedAccountOwner serializedAccountOwner = gson.fromJson(string, SerializedAccountOwner.class);
        return serializedAccountOwner;
    }


}
