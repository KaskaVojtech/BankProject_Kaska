package org.example.Helper_classes.Generation_classes;

import java.util.Random;

public class YearGenerator {
    private Random random = new Random();
    public String generateYear() {
        int year = 2025 + random.nextInt(11);
        return String.valueOf(year);
    }
}
