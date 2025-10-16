package org.example.AccountOwner_classes.Data_classes;

import org.example.AccountOwner_classes.Data_classes.Core_classes.BaseAccountOwner;

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
