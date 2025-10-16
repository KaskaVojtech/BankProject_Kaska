package org.example.Account_classes.Service_classes.AccountOperation_classes;

import org.example.Account_classes.Data_classes.Core.BaseAccount;
import org.example.Account_classes.Service_classes.AccountManager;
import org.example.Account_classes.Service_classes.AccountOperation_classes.Simple_classes.DepositService;
import org.example.Account_classes.Service_classes.AccountOperation_classes.Simple_classes.WithdrawService;
import org.example.Account_classes.Service_classes.Validator_classes.Enums.ValidatorType;
import org.example.Account_classes.Service_classes.Validator_classes.Interfaces.PaymentValidator;
import org.example.Account_classes.Service_classes.Validator_classes.ValidatorRegistry;
import org.example.Card_classes.Data_classes.BasePaymentCard;

public class AccountOperationService {

    private final ValidatorRegistry validatorRegistry;
    private final AccountManager accountManager;

    public AccountOperationService(AccountManager accountManager, ValidatorRegistry validatorRegistry) {
        this.accountManager = accountManager;
        this.validatorRegistry = validatorRegistry;
    }

    public boolean processCardTransaction(BasePaymentCard card, double amount) {
        BaseAccount account = accountManager.findAccountByCard(card);
        if (account == null) return false;

        PaymentValidator validator = validatorRegistry.get(ValidatorType.CARD);
        DepositService depositService = new DepositService(validator);
        WithdrawService withdrawService = new WithdrawService(validator);

        if (amount >= 0) {
            return depositService.deposit(account, amount);
        } else {
            return withdrawService.withdraw(account, Math.abs(amount));
        }
    }
}
