package org.example.Card_classes.Data_classes;

public class BasePaymentCard {
    private String id;
    private String cardNumber;
    private String ccv;
    private String pin;
    private String expireMonth;
    private String expireYear;
    private String cardHolder;

    public String getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCcv() {
        return ccv;
    }

    public String getPin() {
        return pin;
    }

    public String getExpireMonth() {
        return expireMonth;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public BasePaymentCard(String id, String cardNumber, String ccv, String pin, String expireMonth, String expireYear, String cardHolder) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.ccv = ccv;
        this.pin = pin;
        this.expireMonth = expireMonth;
        this.expireYear = expireYear;
        this.cardHolder = cardHolder;
    }
}
