package com.chupakhin.bonusprocessing.state;

import com.chupakhin.bonusprocessing.model.UserAccount;

import java.math.BigDecimal;

/**
 * Состояние оплаты в магазине
 */
public class ShopPay implements PaymentState {
    @Override
    public void process(UserAccount userAccount, BigDecimal amount) {
        userAccount.purchase(amount);  // оплачиваем покупку
        userAccount.setState(new BonusShopAccumulation());  // переходим в состояние начисления бонусов за покупки в магазине
        userAccount.stateProcess(amount);  // запускаем процесс начисления бонусов
    }
}
