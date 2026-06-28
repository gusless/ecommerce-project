package com.lp1.project.app.screens;

import com.lp1.project.app.App;

public class SettingsScreen {
    public static void show() {
        while(true){
            System.out.println("\n=====CONFIGURAÇÕES=====");
            System.out.print("1. Adicionar endereço\n2. Ver informações da conta\n3. Voltar\n: ");

            int op = App.SCANNER.nextInt();
            App.SCANNER.nextLine();

            switch (op) {
                case 1 -> AddAddressScreen.show();
                case 2 -> System.out.println(App.getSession().getCurrentUser());
                case 3 -> CustomerMainScreen.show();
                default -> System.out.println("\nEscolha inválida. Tente novamente.");
            }
        }

    }
}
