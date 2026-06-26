package com.lp1.project.app.screens;

import com.lp1.project.app.App;

public class AdminMainScreen {
    public static void show() {
        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("\n=====MENU ADMIN=====\n1. Adicionar produto\n2. Adicionar categoria\n3. Adicionar transportadora\n4. Editar produto\n5. Editar categoria\n6. Editar transportadora\n7. Sair");
                System.out.print(": ");

                int op = App.SCANNER.nextInt();
                App.SCANNER.nextLine();

                switch (op) {
                    case 1:
                        AddProductScreen.show();
                        break;
                    case 2:
                        AddCategoryScreen.show();
                        break;
                    case 7:
                        exit = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
