package com.chupakhin.bonusprocessing.service;

import com.chupakhin.bonusprocessing.model.UserAccount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserAccountService {
    private final UserAccount userAccount;

    public UserAccountService(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public BigDecimal getEMoneyBalance(){
        return userAccount.geteMoneyBalance();
    }
    public BigDecimal getBankAccountBalance(){
        return userAccount.getBonusBalance();
    }
}
