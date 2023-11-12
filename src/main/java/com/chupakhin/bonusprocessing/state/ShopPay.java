package com.chupakhin.bonusprocessing.state;

import com.chupakhin.bonusprocessing.model.UserAccount;

import java.math.BigDecimal;

/**
 * Состояние оплаты в магазине
 */
public class ShopPay implements PaymentState {
    @Override
    public void process(UserAccount userAccount, BigDecimal amount) {
        userAccount.purchase(amount);
        userAccount.setState(new BonusShopAccumulation());
        userAccount.stateProcess(amount);
    }
}
