package org.example.AccountOwner_classes.Serialization_classes.Service_classes;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.inject.Inject;
import org.example.AccountOwner_classes.Data_classes.Core_classes.BaseAccountOwner;
import org.example.AccountOwner_classes.Factory_classes.AccountOwnerSerializedFactory;
import org.example.AccountOwner_classes.Serialization_classes.Interfaces.Serialization;
import org.example.AccountOwner_classes.Serialization_classes.Data_classes.SerializedAccountOwner;

public class BankAccountOwnerSerializationXML implements Serialization {

    @Inject
    AccountOwnerSerializedFactory accountOwnerSerializedFactory;
    @Inject
    XmlMapper xmlMapper;

    public BankAccountOwnerSerializationXML(AccountOwnerSerializedFactory accountOwnerSerializedFactory, XmlMapper xmlMapper) {
        this.accountOwnerSerializedFactory = accountOwnerSerializedFactory;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public String serialize(Object object) {
        if (!(object instanceof BaseAccountOwner)) {
            throw new ClassCastException("Object is not BaseAccountOwner");
        }

        BaseAccountOwner owner = (BaseAccountOwner) object;
        SerializedAccountOwner serializedAccountOwner =
                accountOwnerSerializedFactory.createSerializedAccountOwner(owner);

        try {
            String xml = xmlMapper.writeValueAsString(serializedAccountOwner);
            System.out.println(xml);
            return xml;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

        /* StringBuilder builder = new StringBuilder();
        builder.append("<SerializedAccountOwner>");
        builder.append("<uuid>").append((serializedAccountOwner.uuid)).append("</uuid>");
        builder.append("<firstName>").append((serializedAccountOwner.firstName)).append("</firstName>");
        builder.append("<lastName>").append((serializedAccountOwner.lastName)).append("</lastName>");
        builder.append("</SerializedAccountOwner>");*/
    }

    @Override
    public Object deserialize(String string) {
        try {
            return xmlMapper.readValue(string, SerializedAccountOwner.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error", e);
        }
    }
}
