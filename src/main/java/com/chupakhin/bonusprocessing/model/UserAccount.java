package com.chupakhin.bonusprocessing.model;

import com.chupakhin.bonusprocessing.state.PaymentState;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// Аккаунт пользователя в банке, содержащий счет денег и счет бонусов
@Component
public class UserAccount {

    // Счет безналичных средств, по дефолту 5000
    @Value("${user.account.default.emoney.balance}")
    private BigDecimal eMoneyBalance;

    // Бонусный счет, по дефолту 0
    @Value("${user.account.default.bonus.balance}")
    private BigDecimal bonusBalance;

    // Текущее состояние
    private PaymentState paymentState;

    // Метод для изменения состояния
    public void setState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    // Запуск процесса текущего состояния
    public void stateProcess(BigDecimal amount) {
        paymentState.process(this, amount);
    }


    public BigDecimal geteMoneyBalance() {
        return eMoneyBalance;
    }

    public BigDecimal getBonusBalance() {
        return bonusBalance;
    }

    // Хватает ли денег на покупку
    public boolean hasMoneyToPay(BigDecimal amount){
        return eMoneyBalance.compareTo(amount) >= 0;
    }

    // Оплата покупки, предварительно проверив, что денег хватает
    public void purchase(BigDecimal amount){
        if(hasMoneyToPay(amount)){
            eMoneyBalance = eMoneyBalance.subtract(amount);
        } else {
            throw new RuntimeException("Not enough money");
        }
    }

    // Берем комиссию
    public void takeCommission(BigDecimal commission){
        eMoneyBalance = eMoneyBalance.subtract(commission);
    }

    // Добавляем бонус на счет
    public void addBonus(BigDecimal bonus){
        bonusBalance = bonusBalance.add(bonus);
    }
}
