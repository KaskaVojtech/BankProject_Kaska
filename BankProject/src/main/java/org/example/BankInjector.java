package org.example;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.example.Helper_classes.Other.Logger.ConsoleLogger;
import org.example.Helper_classes.Other.Logger.Interfaces.Logger;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;
import org.example.Helper_classes.Validator_classes.ValidatorType_classes.CardPaymentValidator;
import org.example.Helper_classes.Validator_classes.ValidatorType_classes.NormalPaymentValidator;

public class BankInjector extends AbstractModule {
    @Override
    protected void configure() {
        bind(PaymentValidator.class)
                .annotatedWith(Names.named("card"))
                .to(CardPaymentValidator.class);

        bind(PaymentValidator.class)
                .annotatedWith(Names.named("normal"))
                .to(NormalPaymentValidator.class);

        bind(Logger.class).to(ConsoleLogger.class);
    }
}
