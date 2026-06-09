package java.com.lp1.project.domain.payment;

import java.math.BigDecimal;
import java.util.Random;

public class PixPayment extends PaymentMethod {
    public String pixKey;

    private static final Random RANDOM = new Random();

    public PixPayment(){
        generatePixKey();
        System.out.println("Chave pix: " + pixKey);
    }

    @Override
    public boolean processPayment(BigDecimal value) {
        System.out.println("Pagamento no PIX de R$" + value);
        return true;
    }

    private void generatePixKey(){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 20; i++){
            sb.append(RANDOM.nextInt(i));
        }
        sb.append("PIXCODE");
        for (int i = 0; i < 10; i++){
            sb.append(RANDOM.nextInt(i));
        }

        //gambiarra
    }

    public String getPixKey() {
        return pixKey;
    }

}
