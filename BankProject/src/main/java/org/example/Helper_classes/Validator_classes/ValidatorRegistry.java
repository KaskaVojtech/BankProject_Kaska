package org.example.Helper_classes.Validator_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.example.Helper_classes.Validator_classes.Enums.ValidatorType;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;
import org.example.Helper_classes.Validator_classes.ValidatorType_classes.CardPaymentValidator;
import org.example.Helper_classes.Validator_classes.ValidatorType_classes.NormalPaymentValidator;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class ValidatorRegistry {

    private final Map<ValidatorType, PaymentValidator> validators;

    @Inject
    NormalPaymentValidator normalPaymentValidator;

    @Inject
    CardPaymentValidator cardPaymentValidator;

    public ValidatorRegistry(@Named("normal") NormalPaymentValidator normalPaymentValidator,@Named("card") CardPaymentValidator cardPaymentValidator) {
        validators = new HashMap<>();
        this.normalPaymentValidator = normalPaymentValidator;
        this.cardPaymentValidator = cardPaymentValidator;
        register(ValidatorType.NORMAL, this.normalPaymentValidator);
        register(ValidatorType.CARD, this.cardPaymentValidator);
    }

    public void register(ValidatorType type, PaymentValidator validator) {
        validators.put(type, validator);
    }

    public PaymentValidator get(ValidatorType type) {
        return validators.getOrDefault(type, validators.get(ValidatorType.NORMAL));
    }
}

