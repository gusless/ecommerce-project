package com.lp1.project.app.forms;

import com.lp1.project.app.App;

import java.time.LocalDate;

public class UserForm {

    public static String loginName() {
        System.out.print("Email ou CPF: ");
        return App.SCANNER.nextLine();
    }

    public static String loginPassword() {
        System.out.print("Senha: ");
        return App.SCANNER.nextLine();
    }

    public static String name() {
        System.out.print("Nome: ");
        return App.SCANNER.nextLine();
    }

    public static LocalDate birth() {
        System.out.print("Nascimento (AAAA-MM-DD): ");
        return LocalDate.parse(App.SCANNER.nextLine());
    }

    public static String cpf() {
        System.out.print("CPF: ");
        return App.SCANNER.nextLine();
    }

    public static String email() {
        System.out.print("E-mail: ");
        return App.SCANNER.nextLine();
    }

    public static String password() {
        System.out.print("Senha: ");
        return App.SCANNER.nextLine();
    }

    public static String phone() {
        System.out.print("Telefone: ");
        return App.SCANNER.nextLine();
    }

}
