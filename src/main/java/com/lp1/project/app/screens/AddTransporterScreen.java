package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.app.forms.AddTransporterForm;
import com.lp1.project.domain.shipping.Transporter;
import com.lp1.project.domain.shipping.TransporterService;

import java.math.BigDecimal;
import java.net.URI;
import java.util.InputMismatchException;

public class AddTransporterScreen {
    private static final TransporterService service = App.getTransporterService();

    public static void show () {
        while(true){
            try {
                System.out.println("\n=====ADICIONAR TRANSPORTADORA=====");
                String name = AddTransporterForm.name();
                BigDecimal shippingFactor = AddTransporterForm.shippingFactor();
                Integer deliveryDaysAdjustment = AddTransporterForm.deliveryDaysAdjustment();
                App.SCANNER.nextLine();
                String contact = AddTransporterForm.contact();
                URI website = AddTransporterForm.website();

                Transporter newTransporter = new Transporter(name, shippingFactor, deliveryDaysAdjustment, contact, website);

                service.createTransporter(App.getSession().getCurrentUser(),  newTransporter);

                System.out.println("\nTransportadora criada com sucesso.");

               AdminMainScreen.show();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite um número válido.");
                App.SCANNER.nextLine();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("1. Tentar novamente\n2. Sair");

                int op = App.SCANNER.nextInt();
                App.SCANNER.nextLine();

                if (op == 2) {
                    AdminMainScreen.show();
                }
            }

        }
    }
}
