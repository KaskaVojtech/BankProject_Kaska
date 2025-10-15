package org.example.Services.Generators;

import java.util.Random;

public class FourDigitsGenerator {

    private Random random = new Random();

    public String generateFourDigit() {
        int number = 1000 + random.nextInt(9000);
        return String.valueOf(number);
    }
}
