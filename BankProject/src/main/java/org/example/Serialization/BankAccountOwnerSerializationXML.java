package org.example.Serialization;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.AccountsOwners.BaseAccountOwner;
import org.example.Factories.AccountOwnerSerializedFactory;
import org.example.Serialization.Objects.SerializedAccountOwner;

public class BankAccountOwnerSerializationXML implements Serialization {

    AccountOwnerSerializedFactory accountOwnerSerializedFactory;
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
