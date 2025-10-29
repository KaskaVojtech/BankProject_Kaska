package org.example.Helper_classes.Generation_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class FourDigitsGenerator {

    @Inject
    private Random random;

    public String generateFourDigit() {
        int number = 1000 + random.nextInt(9000);
        return String.valueOf(number);
    }
}
