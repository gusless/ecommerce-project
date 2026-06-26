package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.user.User;
import com.lp1.project.domain.user.UserRole;

import java.util.InputMismatchException;

public class MainMenuScreen {
    public static void show() {
        while(true){
            boolean isLoggedIn = false;
            while(!isLoggedIn){
                try {
                    System.out.println("\n=====MENU=====\n1. Login\n2. Criar conta\n3. Sair");
                    System.out.print(": ");
                    int op = App.SCANNER.nextInt();
                    App.SCANNER.nextLine();

                    switch(op){
                        case 1 -> LoginScreen.show(App.getSession());
                        case 2 -> RegisterScreen.show(App.getSession());
                        case 3 -> System.exit(0);
                        default -> System.out.println("\nOpção inválida. Tente novamente.");
                    }

                    isLoggedIn = App.getSession().isLoggedIn();
                } catch (InputMismatchException e) {
                    System.out.println("\nDigite um número válido.");
                    App.SCANNER.nextLine();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    App.SCANNER.nextLine();
                }
            }

            while(App.getSession().isLoggedIn()){
                User user = App.getSession().getCurrentUser();

                if (user.getRole().equals(UserRole.ADMIN)){
                    AdminMainScreen.show();
                } else {
                    CustomerMainScreen.show();
                }
            }
        }
    }
}
