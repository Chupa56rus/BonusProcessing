package com.chupakhin.bonusprocessing.state;

import com.chupakhin.bonusprocessing.model.UserAccount;

import java.math.BigDecimal;

/**
 * Состояние оплаты онлайн
 */
public class OnlinePay implements PaymentState {
    @Override
    public void process(UserAccount userAccount, BigDecimal amount) {
        userAccount.purchase(amount);
        userAccount.setState(new BonusOnlineAccumulation());
        userAccount.stateProcess(amount);
    }
}
