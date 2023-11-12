package com.chupakhin.bonusprocessing.state;

import com.chupakhin.bonusprocessing.model.UserAccount;

import java.math.BigDecimal;

/**
 * Состояние взимания комиссии
 */
public class OnlineCommission implements PaymentState {

    // Размер комиссии
    private static final BigDecimal COMMISSION = BigDecimal.valueOf(0.1);

    @Override
    public void process(UserAccount userAccount, BigDecimal amount) {
        userAccount.takeCommission(amount.multiply(COMMISSION));
    }
}
