package com.lp1.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        UserRepository repository = new UserRepository();

        System.out.println("Cadastro de Usuário");

        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("Data de nascimento (AAAA-MM-DD): ");
        LocalDate birth = LocalDate.parse(scanner.nextLine());

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String password = scanner.nextLine();

        System.out.print("Telefone: ");
        String numberPhone = scanner.nextLine();

        User user = new User(name, birth, cpf, email, password, numberPhone);

        repository.save(user);

        System.out.println("\nUsuário salvo com sucesso!");

        System.out.println("\nUsuários cadastrados:");

        for (User u : repository.findAll()) {
            System.out.println(u);
        }
        */
        scanner.close();
    }
}
