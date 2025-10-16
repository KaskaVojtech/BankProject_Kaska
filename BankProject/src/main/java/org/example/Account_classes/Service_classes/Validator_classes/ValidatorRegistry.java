package org.example.Account_classes.Service_classes.Validator_classes;

import org.example.Account_classes.Service_classes.Validator_classes.Enums.ValidatorType;
import org.example.Account_classes.Service_classes.Validator_classes.Interfaces.PaymentValidator;
import org.example.Account_classes.Service_classes.Validator_classes.Simple_classes.CardPaymentValidator;
import org.example.Account_classes.Service_classes.Validator_classes.Simple_classes.NormalPaymentValidator;

import java.util.HashMap;
import java.util.Map;


public class ValidatorRegistry {

    private final Map<ValidatorType, PaymentValidator> validators = new HashMap<>();

    public ValidatorRegistry() {
        register(ValidatorType.NORMAL, new NormalPaymentValidator());
        register(ValidatorType.CARD, new CardPaymentValidator());
    }

    public void register(ValidatorType type, PaymentValidator validator) {
        validators.put(type, validator);
    }

    public PaymentValidator get(ValidatorType type) {
        return validators.getOrDefault(type, validators.get(ValidatorType.NORMAL));
    }
}

