package com.chupakhin.bonusprocessing.state;

import com.chupakhin.bonusprocessing.model.UserAccount;

import java.math.BigDecimal;

/**
 * Состояние начисления бонуса при онлайн покупках
 */
public class BonusOnlineAccumulation implements PaymentState {

    // Порог для минимального бонуса
    private static final BigDecimal LIMIT_FOR_MIN_BONUS = BigDecimal.valueOf(20);

    // Порог для максимального бонуса
    private static final BigDecimal LIMIT_FOR_MAX_BONUS = BigDecimal.valueOf(300);

    // Процент минимального бонуса
    private static final BigDecimal MIN_BONUS_PERCENT = BigDecimal.valueOf(0.17);

    // Процент максимального бонуса
    private static final BigDecimal MAX_BONUS_PERCENT = BigDecimal.valueOf(0.3);


    /**
     * Если сумма покупки < 20 рублей, то переходим в состояние комиссии.
     * Если сумма покупки >= 20, но < 300, то начисляем бонус 17%
     * Если сумма покупки >= 300, то начисляем бонус 30%
     */
    @Override
    public void process(UserAccount userAccount, BigDecimal amount) {
        if(amount.compareTo(LIMIT_FOR_MIN_BONUS) < 0){
            userAccount.setState(new OnlineCommission());
            userAccount.stateProcess(amount);
        } else {
            BigDecimal percent = amount.compareTo(LIMIT_FOR_MAX_BONUS) >= 0 ? MAX_BONUS_PERCENT : MIN_BONUS_PERCENT;
            userAccount.addBonus(amount.multiply(percent));
        }
    }
}
