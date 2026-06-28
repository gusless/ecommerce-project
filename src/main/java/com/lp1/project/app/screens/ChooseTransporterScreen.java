package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.shipping.Transporter;

import java.util.List;

public class ChooseTransporterScreen {
    public static Transporter show() {
        List<Transporter> transporters = App.getTransporterRepository().findAll();

        if (transporters.isEmpty()){
            throw new RuntimeException("\nNenhuma transportadora encontrada, desculpe.");
        }

        for (Transporter transporter : transporters) {
            System.out.println(transporter.getId() + " - " + transporter.getName());
        }
        System.out.println("\nEscolha a transportadora: ");

        int op = App.SCANNER.nextInt();
        App.SCANNER.nextLine();

        if (op < 1 || op > transporters.size()) {
            throw new RuntimeException("\nTransportadora inválida.");
        }
        
        return transporters.get(op - 1);
    }
}
