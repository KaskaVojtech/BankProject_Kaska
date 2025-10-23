package org.example.Helper_classes.Validator_classes.ValidatorType_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Helper_classes.Other.Logger.Interfaces.Logger;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;

public class CardPaymentValidator implements PaymentValidator {

    private double cardLimit = 5_000;
    private Logger logger;

    public CardPaymentValidator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean canDeposit(BaseAccount account, double amount) {
        logger.log("Card Deposit:");
        if(amount <= 0){
            logger.log("Amount can't be negative or zero");
            return false;
        }
        if(amount > cardLimit){
            logger.log("Amount can't be greater than card limit: " + cardLimit);
            return false;
        }
        logger.log("Deposit happend succsesfully");
        return true;
    }

    @Override
    public boolean canWithdraw(BaseAccount account, double amount) {
        logger.log("Card Withdraw:");
        if(amount <= 0){
            logger.log("Amount can't negative or zero");
            return false;
        }
        if(account.getBalance() < amount){
            logger.log("Amount can't be greater than account balance: " + account.getBalance());
            return false;
        }
        if(amount > cardLimit){
            logger.log("Amount can't be greater than card limit: " + amount);
            return false;
        }
        logger.log("Withdraw happend succsesfully");
        return true;
    }

    @Override
    public boolean canTransfer(BaseAccount from, BaseAccount to, double amount) {
        logger.log("Card Transfer:");
        if(amount <= 0){
            logger.log("Amount is less than 0 or 0: " + amount);
            return false;
        }
        if(from.getBalance() <= amount){
            logger.log("Amount is greater than account balance: " + from.getBalance());
            return false;
        }
        logger.log("Transfer happend succsesfully");
        return  true;
    }
}


