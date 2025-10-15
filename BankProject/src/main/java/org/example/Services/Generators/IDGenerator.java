package org.example.Services.Generators;

import java.util.Random;
import java.util.UUID;

public class IDGenerator {

    private int counter = 0;
    private  Random random = new Random();

    public String makeID_UUID(){
        return UUID.randomUUID().toString();
    }
    public String makeAccountNumber(){
        return String.format("%06d",++counter);
    }

}
