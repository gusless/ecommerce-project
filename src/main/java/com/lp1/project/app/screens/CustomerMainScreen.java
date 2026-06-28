package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.user.Customer;

public class CustomerMainScreen {
    public static void show() {
        try {
            System.out.println("\n=====CUSTOMER MENU=====\n1. Fazer pedido\n2. Ver pedidos\n3. Ver reviews\n4. Configurações\n5. Sair");
            System.out.print(": ");

            int op = App.SCANNER.nextInt();
            App.SCANNER.nextLine();

            switch (op) {
                case 1 -> NewOrderScreen.show();
                case 2 -> SeePreviousOrdersScreen.show();
                case 3 -> SeeOrdersReviewsScreen.show();
                case 4 -> SettingsScreen.show();
                case 5 -> App.getSession().logout();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
