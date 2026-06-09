package java.com.lp1.project.domain.payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class BankSlipPayment extends PaymentMethod {
    private String barcode;
    private LocalDate dueDate;

    private static final Random RANDOM = new Random();

    public BankSlipPayment() {
        generateBarcode();
        dueDate = LocalDate.now().plusDays(3);
        System.out.println("Código de barras: " + barcode);
        System.out.println("Vencimento: "
                + dueDate.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
    }

    @Override
    public boolean processPayment(BigDecimal value) {
        System.out.println("Pagamento no boleto de R$" + value);
        return true;
    }

    private void generateBarcode(){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 44; i++){
            sb.append(RANDOM.nextInt(i));
        }
        barcode = sb.toString();

        //gambiarra
    }

    public String getBarcode() {
        return barcode;
    }
}
