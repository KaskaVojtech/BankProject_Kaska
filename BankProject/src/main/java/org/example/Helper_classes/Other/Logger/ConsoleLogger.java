package org.example.Helper_classes.Other.Logger;

import com.google.inject.Singleton;
import org.example.Helper_classes.Other.Logger.Interfaces.Logger;

@Singleton
public class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println(message);
    }
}
