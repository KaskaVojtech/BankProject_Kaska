package org.example.Serialization.Objects;

public class SerializedAccountOwner {
    public String uuid;
    public String firstName;
    public String lastName;

    public SerializedAccountOwner(String uuid, String firstName, String lastName) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
