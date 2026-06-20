package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.app.Session;
import com.lp1.project.app.forms.UserForm;
import com.lp1.project.domain.user.User;
import com.lp1.project.domain.user.UserService;

import java.time.LocalDate;

public class RegisterScreen {
    private static final UserService service = App.getUserService();

    public static void show(Session session) {
        while(true){
            try {
                String name = UserForm.name();
                LocalDate birth = UserForm.birth();
                String cpf = UserForm.cpf();
                String email = UserForm.email();
                String password = UserForm.password();
                String phone = UserForm.phone();

                User user = service.register(name, birth, cpf, email, password, phone);

                System.out.println("Usuário criado: " + user.getName());

                session.login(user);

                return;

            }  catch (Exception e) {
                System.out.println(e.getMessage());

                System.out.println("1. Tentar novamente");
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
