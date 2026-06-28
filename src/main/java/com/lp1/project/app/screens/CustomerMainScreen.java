package com.lp1.project.app.screens;

import com.lp1.project.app.App;

public class CustomerMainScreen {
    public static void show() {
        try {
            System.out.println("\n=====CUSTOMER MENU=====\n1. Fazer pedido\n2. Ver pedidos\n3. Ver reviews de produtos\n4. Ver minhas reviews\n5. Configurações\n6. Sair");
            System.out.print(": ");

            int op = App.SCANNER.nextInt();
            App.SCANNER.nextLine();

            switch (op) {
                case 1 -> NewOrderScreen.show();
                case 2 -> SeePreviousOrdersScreen.show();
                case 3 -> SeeProductReviewScreen.show();
                case 4 -> SeeMyReviewsScreen.show();
                case 5 -> SettingsScreen.show();
                case 6 -> {
                    App.getSession().logout();
                    MainMenuScreen.show();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
