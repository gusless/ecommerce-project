package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.app.Session;
import com.lp1.project.app.forms.UserForm;
import com.lp1.project.domain.user.User;
import com.lp1.project.domain.user.UserService;

public class LoginScreen {
    private static final UserService service = App.getUserService();

    public static void show(Session session) {
        while (true) {
            try {
                String login = UserForm.loginName();
                String password = UserForm.password();

                User user = service.login(login, password);

                session.login(user);

                System.out.println("Login bem-sucedido, seja bem-vindo(a) " + user.getName());

                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());

                System.out.println("1. Tentar de novo");
                System.out.println("2. Sair");

                int op = App.SCANNER.nextInt();
                App.SCANNER.nextLine();

                if (op == 2) {
                    return;
                }
            }
        }
    }
}
