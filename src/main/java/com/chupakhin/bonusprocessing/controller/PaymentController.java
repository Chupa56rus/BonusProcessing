package com.chupakhin.bonusprocessing.controller;

import com.chupakhin.bonusprocessing.service.PaymentService;
import com.chupakhin.bonusprocessing.type.PaymentType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{type}/{amount}")
    public ResponseEntity<String> payment(@PathVariable String type, @PathVariable String amount) {
        paymentService.payment(PaymentType.valueOf(type.toUpperCase()), new BigDecimal(amount));
        return ResponseEntity.ok("Payment completed");
    }
}
