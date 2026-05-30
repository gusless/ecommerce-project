package com.lp1.project.domain.payment;

import java.time.LocalDate;

public class BankSlipPayment extends PaymentMethod {
    private String barcode;
    private LocalDate dueDate;
}
