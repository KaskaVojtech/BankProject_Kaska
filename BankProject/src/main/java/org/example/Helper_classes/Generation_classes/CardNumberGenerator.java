package org.example.Helper_classes.Generation_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class CardNumberGenerator {
    @Inject
    private Random random;

    public CardNumberGenerator(Random random) {
        this.random = random;
    }

    public String generateCardNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
