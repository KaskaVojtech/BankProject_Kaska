package org.example.AccountsOwners;

public class StudentAccountOwner extends BaseAccountOwner {

    String school;

    public StudentAccountOwner(String uuid, String firstName, String lastName, String school) {
        super(uuid, firstName, lastName);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }
}
