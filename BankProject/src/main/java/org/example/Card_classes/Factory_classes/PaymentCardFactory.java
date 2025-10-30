package org.example.Card_classes.Factory_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Card_classes.Data_classes.BasePaymentCard;
import org.example.Helper_classes.Generation_classes.*;

@Singleton
public class PaymentCardFactory {
    @Inject
    IDGenerator IDGenerator;
    @Inject
    FourDigitsGenerator fourDigitsGenerator;
    @Inject
    YearGenerator yearGenerator;
    @Inject
    CardNumberGenerator cardNumberGenerator;
    @Inject
    MonthGenerator monthGenerator;
    @Inject
    public BasePaymentCard createBasePaymentCard(String cardHolder) {
        return new BasePaymentCard(IDGenerator.makeID_UUID(), cardNumberGenerator.generateCardNumber(),fourDigitsGenerator.generateFourDigit(), fourDigitsGenerator.generateFourDigit(), monthGenerator.generateMonth(), yearGenerator.generateYear(),cardHolder);
    }
}
