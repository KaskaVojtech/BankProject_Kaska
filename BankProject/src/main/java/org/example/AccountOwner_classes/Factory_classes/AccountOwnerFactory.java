package org.example.AccountOwner_classes.Factory_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Helper_classes.Generation_classes.IDGenerator;
import org.example.AccountOwner_classes.Data_classes.AdultAccountOwner;
import org.example.AccountOwner_classes.Data_classes.StudentAccountOwner;
@Singleton
public class AccountOwnerFactory {
    @Inject
    IDGenerator IDGenerator;

    @Inject
    public AccountOwnerFactory(IDGenerator IDGenerator) {
        this.IDGenerator = IDGenerator;
    }

    public AdultAccountOwner createAdultAccountOwner(String name, String surname) {
        return new AdultAccountOwner(IDGenerator.makeID_UUID(), name, surname);
    }

    public StudentAccountOwner createStudentAccountOwner(String name, String surname, String school) {
        return new StudentAccountOwner(IDGenerator.makeID_UUID(), name, surname, school);
    }

}
