package org.example.Factories;

import org.example.Services.Generators.*;
import org.example.cards.BasePaymentCard;

public class PaymentCardFactory {
    IDGenerator IDGenerator;
    FourDigitsGenerator fourDigitsGenerator;
    YearGenerator yearGenerator;
    CardNumberGenerator cardNumberGenerator;
    MonthGenerator monthGenerator;


    public PaymentCardFactory(IDGenerator IDGenerator, FourDigitsGenerator fourDigitsGenerator, YearGenerator yearGenerator, CardNumberGenerator cardNumberGenerator, MonthGenerator monthGenerator) {
        this.IDGenerator = IDGenerator;
        this.fourDigitsGenerator = fourDigitsGenerator;
        this.yearGenerator = yearGenerator;
        this.cardNumberGenerator = cardNumberGenerator;
        this.monthGenerator = monthGenerator;
    }

    public BasePaymentCard createBasePaymentCard(String cardHolder) {
        return new BasePaymentCard(IDGenerator.makeID_UUID(), cardNumberGenerator.generateCardNumber(),fourDigitsGenerator.generateFourDigit(), fourDigitsGenerator.generateFourDigit(), monthGenerator.generateMonth(), yearGenerator.generateYear(),cardHolder);
    }
}
