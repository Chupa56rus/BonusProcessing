package com.chupakhin.bonusprocessing.controller;

import com.chupakhin.bonusprocessing.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/bankAccountOfEMoney")
    public ResponseEntity<BigDecimal> getBankAccountBalance() {
        return ResponseEntity.ok(userAccountService.getBankAccountBalance());
    }

    @GetMapping("/money")
    public ResponseEntity<BigDecimal> getEMoneyBalance() {
        return ResponseEntity.ok(userAccountService.getEMoneyBalance());
    }
}
