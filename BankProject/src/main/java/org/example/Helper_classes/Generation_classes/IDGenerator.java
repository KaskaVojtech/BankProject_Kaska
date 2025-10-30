package org.example.Helper_classes.Generation_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Random;
import java.util.UUID;
@Singleton
public class IDGenerator {

    private int counter = 0;
    @Inject
    private  Random random;

    @Inject
    public IDGenerator(Random random) {
        this.random = random;
    }

    public String makeID_UUID(){
        return UUID.randomUUID().toString();
    }
    public String makeAccountNumber(){
        return String.format("%06d",++counter);
    }

}
