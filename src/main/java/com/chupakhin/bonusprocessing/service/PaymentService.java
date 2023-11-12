package com.chupakhin.bonusprocessing.service;

import com.chupakhin.bonusprocessing.state.OnlinePay;
import com.chupakhin.bonusprocessing.state.ShopPay;
import com.chupakhin.bonusprocessing.model.UserAccount;
import com.chupakhin.bonusprocessing.type.PaymentType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    private final UserAccount userAccount;

    public PaymentService(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    // Присваиваем состояние покупки (магазин или онлайн) и запускаем исполнение состояния
    public void payment(PaymentType type, BigDecimal amount) {
        if (PaymentType.SHOP.equals(type)) {
            userAccount.setState(new ShopPay());
        } else if (PaymentType.ONLINE.equals(type)) {
            userAccount.setState(new OnlinePay());
        }
        userAccount.stateProcess(amount);
    }
}
