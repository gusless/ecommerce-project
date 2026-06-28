package com.lp1.project.app.screens;

import com.lp1.project.app.App;

import java.util.InputMismatchException;

public class AdminMainScreen {
    public static void show() {
        while (App.getSession().isLoggedIn()) {
            try {
                System.out.println("\n=====MENU ADMIN=====\n1. Adicionar produto\n2. Adicionar categoria\n3. Adicionar transportadora\n4. Editar produto\n5. Editar categoria\n6. Editar transportadora\n7. Sair");
                System.out.print(": ");

                int op = App.SCANNER.nextInt();
                App.SCANNER.nextLine();

                switch (op) {
                    case 1 -> AddProductScreen.show();
                    case 2 -> AddCategoryScreen.show();
                    case 3 -> AddTransporterScreen.show();
                    case 7 -> {
                        App.getSession().logout();
                        MainMenuScreen.show();
                    }

                    default -> System.out.println("\nOpção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nDigite um número válido.");
                App.SCANNER.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                App.SCANNER.nextLine();
            }
        }

    }
}
