package org.example.Factories;

import org.example.Services.Generators.IDGenerator;
import org.example.AccountsOwners.AdultAccountOwner;
import org.example.AccountsOwners.StudentAccountOwner;

public class AccountOwnerFactory {
    IDGenerator IDGenerator = new IDGenerator();

    public AdultAccountOwner createAdultAccountOwner(String name, String surname) {
        return new AdultAccountOwner(IDGenerator.makeID_UUID(), name, surname);
    }

    public StudentAccountOwner createStudentAccountOwner(String name, String surname, String school) {
        return new StudentAccountOwner(IDGenerator.makeID_UUID(), name, surname, school);
    }

}
