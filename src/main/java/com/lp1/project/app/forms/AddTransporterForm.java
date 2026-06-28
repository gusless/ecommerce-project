package com.lp1.project.app.forms;

import com.lp1.project.app.App;
import com.lp1.project.domain.shipping.Transporter;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

public class AddTransporterForm {
    public static String name() {
        System.out.print("Nome da transportadora: ");
        return App.SCANNER.nextLine();
    }

    public static BigDecimal shippingFactor() {
        System.out.print("Fator de envio da transportadora: ");
        return App.SCANNER.nextBigDecimal();
    }

    public static Integer deliveryDaysAdjustment() {
        System.out.print("Ajuste no tempo de entrega (dias): ");
        return App.SCANNER.nextInt();
    }

    public static String contact() {
        System.out.print("Contato (e-mail ou telefone): ");
        return App.SCANNER.nextLine();
    }

    public static URI website() throws URISyntaxException {
        System.out.print("Website: ");
        String website = App.SCANNER.nextLine();
        return new URI(website);
    }

}
