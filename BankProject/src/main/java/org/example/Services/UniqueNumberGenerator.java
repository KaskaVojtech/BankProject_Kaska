package org.example.Services;

import java.util.UUID;

public class UniqueNumberGenerator {

    private int counter = 0;

    public String makeID_UUID(){
        return UUID.randomUUID().toString();
    }
    public String makeAccountNumber(){
        return String.format("%06d",++counter);
    }
}
