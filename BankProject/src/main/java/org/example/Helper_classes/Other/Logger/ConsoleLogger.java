package org.example.Helper_classes.Other.Logger;

import org.example.Helper_classes.Other.Logger.Interfaces.Logger;

public class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println(message);
    }
}
