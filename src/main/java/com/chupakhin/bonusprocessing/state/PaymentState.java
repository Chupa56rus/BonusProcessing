package com.chupakhin.bonusprocessing.state;

import com.chupakhin.bonusprocessing.model.UserAccount;

import java.math.BigDecimal;

public interface PaymentState {
    void process(UserAccount userAccount, BigDecimal amount);
}
