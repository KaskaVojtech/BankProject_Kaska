package org.example.Services.Generators;

import java.util.Random;

public class YearGenerator {
    private Random random = new Random();
    public String generateYear() {
        int year = 2025 + random.nextInt(11);
        return String.valueOf(year);
    }
}
