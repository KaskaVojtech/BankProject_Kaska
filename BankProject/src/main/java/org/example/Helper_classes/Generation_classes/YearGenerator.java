package org.example.Helper_classes.Generation_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class YearGenerator {
    @Inject
    private Random random;

    @Inject
    public YearGenerator(Random random) {
        this.random = random;
    }

    public String generateYear() {
        int year = 2025 + random.nextInt(11);
        return String.valueOf(year);
    }
}
