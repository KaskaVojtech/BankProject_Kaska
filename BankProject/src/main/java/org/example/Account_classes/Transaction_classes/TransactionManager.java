package org.example.Account_classes.Transaction_classes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Card_classes.Data_classes.BasePaymentCard;
import org.example.Helper_classes.Validator_classes.Interfaces.PaymentValidator;
import org.example.Helper_classes.Validator_classes.ValidatorType_classes.CardPaymentValidator;
import org.example.Helper_classes.Validator_classes.ValidatorType_classes.NormalPaymentValidator;
import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.DepositTransactionService;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.TransferTransactionService;
import org.example.Account_classes.Service_classes.AccountMoneyOperation_classes.Operations_classes.WithdrawalTransactionService;
import org.example.Account_classes.Service_classes.Manager_classes.AccountManager;

@Singleton
public class TransactionManager {

    @Inject
    DepositTransactionService depositService;
    @Inject
    WithdrawalTransactionService withdrawService;
    @Inject
    TransferTransactionService transferService;

    @Inject
    AccountManager managerAccount;

    @Inject
    CardPaymentValidator cardValidator;

    @Inject
    NormalPaymentValidator normalValidator;

    private Transaction processTransaction(
            TransactionType type,
            BaseAccount sender,
            BaseAccount receiver,
            double amount,
            TransactionMethod method,
            PaymentValidator validator) {

        if (!validate(type, sender, receiver, amount, validator)) {
            throw new IllegalArgumentException("Payment validation failed");
        }

        TransactionService transactionService;

        switch(type){
            case TransactionType.DEPOSIT:
                transactionService = depositService;
                break;
            case TransactionType.WITHDRAWAL:
                transactionService = withdrawService;
                break;
            case TransactionType.TRANSFER:
                transactionService = transferService;
                break;
            default:
                throw new IllegalArgumentException("Invalid TransactionType");

        }

        Transaction t = transactionService.process(sender, receiver, amount, method);

        sender.addTransaction(t);
        if (receiver != null) {
            receiver.addTransaction(t);
        }

        return t;
    }

    private boolean validate(TransactionType type,
                             BaseAccount sender,
                             BaseAccount receiver,
                             double amount,
                             PaymentValidator validator) {

        switch (type) {
            case DEPOSIT:
                return validator.canDeposit(receiver, amount);

            case WITHDRAWAL:
                return validator.canWithdraw(sender, amount);

            case TRANSFER:
                return validator.canTransfer(sender, receiver, amount);

            default:
                return false;
        }
    }

    public Transaction processCardTransaction(
            TransactionType type,
            BasePaymentCard senderCard,
            BaseAccount receiver,
            double amount
    ) {
        BaseAccount sender = managerAccount.findAccountByCard(senderCard);
        return processTransaction(type, sender, receiver, amount, TransactionMethod.CARD, cardValidator);
    }


    public Transaction processNormalTransaction(
            TransactionType type,
            BaseAccount sender,
            BaseAccount receiver,
            double amount
    ) {
        return processTransaction(type, sender, receiver, amount,TransactionMethod.NORMAL ,normalValidator);
    }
}
