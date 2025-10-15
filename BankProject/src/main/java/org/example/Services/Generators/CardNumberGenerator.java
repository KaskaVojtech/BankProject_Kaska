package org.example.Services.Generators;

import java.util.Random;

public class CardNumberGenerator {
    private Random random = new Random();

    public String generateCardNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
