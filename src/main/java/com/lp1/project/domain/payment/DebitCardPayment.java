package com.lp1.project.domain.payment;

import java.math.BigDecimal;

public class DebitCardPayment extends PaymentMethod {
    private String carNumber;
    private String holderName;
    private String expirationDate;

    public DebitCardPayment(String carNumber, String holderName,
                             String expirationDate) {
        this.carNumber = carNumber;
        this.holderName = holderName;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean processPayment(BigDecimal value) {
        System.out.println("\nPagamento no débito de R$" + value);
        return true;
    }

    @Override
    public String toString() {
        return "Cartão de Débito";
    }
}
