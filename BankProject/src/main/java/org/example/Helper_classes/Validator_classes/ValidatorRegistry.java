package org.example.Helper_classes.Validator_classes;

import org.example.Helper_classes.Validator_classes.Enums.ValidatorType;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;
import org.example.Helper_classes.Validator_classes.Simple_classes.CardPaymentValidator;
import org.example.Helper_classes.Validator_classes.Simple_classes.NormalPaymentValidator;

import java.util.HashMap;
import java.util.Map;


public class ValidatorRegistry {

    private final Map<ValidatorType, PaymentValidator> validators;

    public ValidatorRegistry(NormalPaymentValidator normalPaymentValidator, CardPaymentValidator cardPaymentValidator) {
        validators = new HashMap<>();
        register(ValidatorType.NORMAL, normalPaymentValidator);
        register(ValidatorType.CARD, cardPaymentValidator);
    }

    public void register(ValidatorType type, PaymentValidator validator) {
        validators.put(type, validator);
    }

    public PaymentValidator get(ValidatorType type) {
        return validators.getOrDefault(type, validators.get(ValidatorType.NORMAL));
    }
}

