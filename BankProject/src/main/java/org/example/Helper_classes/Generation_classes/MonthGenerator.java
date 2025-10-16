package org.example.Helper_classes.Generation_classes;

import java.util.Random;

public class MonthGenerator {
    private Random random = new Random();
    public String generateMonth() {
        int month = 1 + random.nextInt(12);
        return String.format("%02d", month);
    }

}
