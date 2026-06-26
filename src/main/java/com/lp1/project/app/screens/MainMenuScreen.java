package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.user.UserRole;

public class MainMenuScreen {
    public static void show() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=====MENU=====\n1. Login\n2. Criar conta\n3. Sair");
            System.out.print(": ");
            int op = App.SCANNER.nextInt();
            App.SCANNER.nextLine();

            switch(op){
                case 1:
                    LoginScreen.show(App.getSession());
                    if (App.getSession().isLoggedIn()) {
                        exit = true;
                    }
                    break;
                case 2:
                    RegisterScreen.show(App.getSession());
                    if (App.getSession().isLoggedIn()) {
                        exit = true;
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }

        exit = false;
        while(!exit) {

            boolean isAdmin = App.getSession().getCurrentUser().getRole().equals(UserRole.ADMIN);
            if (isAdmin) {
                AdminMainScreen.show();
            } else {
                CustomerMainScreen.show();
            }
        }

    }
}
