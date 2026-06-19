package com.lp1.project.app;

import com.lp1.project.domain.repository.UserRepository;
import com.lp1.project.domain.user.User;
import com.lp1.project.domain.user.UserService;

import java.time.LocalDate;
import java.util.Scanner;

public class UserApp {

    public static void testUser() {

        Scanner scanner = new Scanner(System.in);

        UserRepository repository = new UserRepository();
        UserService service = new UserService(repository);

        System.out.println("Cadastro de usuário");

        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("Nascimento (AAAA-MM-DD): ");
        LocalDate birth = LocalDate.parse(scanner.nextLine());

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String password = scanner.nextLine();

        System.out.print("Telefone: ");
        String phone = scanner.nextLine();

        User user = service.register(name, birth, cpf, email, password, phone);

        System.out.println("\nUsuário criado:");

        System.out.println(user);

        System.out.println("\nUsuários cadastrados:");

        repository.findAll()
                .forEach(System.out::println);
    }
}