package com.lp1.project.domain.shipping;

import java.math.BigDecimal;

public class Shipping {
    Transporter transporter;
    BigDecimal shippingValue;

    public Transporter getTransporter() {
        return transporter;
    }

    public BigDecimal getShippingValue() {
        return shippingValue;
    }
}
