package org.example.Factories;

import org.example.Services.UniqueNumberGenerator;
import org.example.AccountsOwners.AdultAccountOwner;
import org.example.AccountsOwners.StudentAccountOwner;

public class AccountOwnerFactory {
    UniqueNumberGenerator uniqueNumberGenerator = new UniqueNumberGenerator();

    public AdultAccountOwner createAdultAccountOwner(String name, String surname) {
        return new AdultAccountOwner(uniqueNumberGenerator.makeID_UUID(), name, surname);
    }

    public StudentAccountOwner createStudentAccountOwner(String name, String surname, String school) {
        return new StudentAccountOwner(uniqueNumberGenerator.makeID_UUID(), name, surname, school);
    }

}
