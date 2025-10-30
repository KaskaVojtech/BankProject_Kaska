package org.example.Helper_classes.Generation_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class MonthGenerator {
    @Inject
    private Random random;

    @Inject
    public MonthGenerator(Random random) {
        this.random = random;
    }

    public String generateMonth() {
        int month = 1 + random.nextInt(12);
        return String.format("%02d", month);
    }

}
