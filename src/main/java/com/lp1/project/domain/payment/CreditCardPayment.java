package java.com.lp1.project.domain.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCardPayment extends PaymentMethod {
    private String cardNumber;
    private String holderName;
    private Integer installments;

    public CreditCardPayment(String carNumber, String holderName, Integer installments) {
        this.cardNumber = carNumber;
        this.holderName = holderName;
        this.installments = installments;
    }

    @Override
    public boolean processPayment(BigDecimal value) {

        if (installments > 1)
            System.out.println("Pagamento no cartão com " +
                    installments + " parcelas de R$" +
                    value.divide(BigDecimal.
                            valueOf(installments), 2, RoundingMode.HALF_UP));
        else
            System.out.println("Pagamento no cartão de R$" + value);
        return true;
    }

    public Integer getInstallments() {
        return installments;
    }
}
