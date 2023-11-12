package com.chupakhin.bonusprocessing.state;

import com.chupakhin.bonusprocessing.model.UserAccount;

import java.math.BigDecimal;

/**
 * Состояние начисления бонуса при покупках в магазине
 */
public class BonusShopAccumulation implements PaymentState {

    // Процент бонусов
    private static final BigDecimal BONUS_PERCENT = BigDecimal.valueOf(0.1);

    @Override
    public void process(UserAccount userAccount, BigDecimal amount) {
        userAccount.addBonus(amount.multiply(BONUS_PERCENT));
    }
}
