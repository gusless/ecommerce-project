package java.com.lp1.project.domain.payment;

import java.math.BigDecimal;

public abstract class PaymentMethod {
    public abstract boolean processPayment(BigDecimal value);
}
