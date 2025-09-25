package org.example.AccountsOwners;

public class BaseAccountOwner {
    private String uuid;
    private String firstName;
    private String lastName;

    public BaseAccountOwner(String uuid, String firstName, String lastName) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUuid() {
        return uuid;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}
