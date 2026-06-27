package com.lp1.project.domain.user;

import com.lp1.project.domain.repository.UserRepository;

import java.time.LocalDate;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User login(String login, String password){
        User user = repository.findByCPF(login);

        if (user == null)
            user = repository.findByEmail(login);

        if (user == null)
            throw new RuntimeException("\nLogin não cadastrado");

        if (!user.getPassword().equals(password))
            throw new RuntimeException("\nSenha incorreta");

        return user;
    }

    public Customer register(String name, LocalDate birth,
                         String cpf, String email, String password,
                         String numberPhone){

        validBirth(birth);
        validCpfFormat(cpf);
        validEmail(email);
        validPassword(password);
        validNumberPhone(numberPhone);

        if (repository.findByEmail(email) != null)
            throw new IllegalArgumentException("\nEste e-mail já está sendo utilizado");
        if (repository.findByCPF(cpf) != null)
            throw new IllegalArgumentException("\nEste CPF já está cadastrado.");

        Customer user = new Customer(
                name,
                birth,
                cpf,
                email,
                password,
                numberPhone
        );

        repository.save(user);

        return user;
    }

    private void validNumberPhone(String numberPhone) {
        numberPhone = numberPhone.replaceAll("\\D", "");
        if (!numberPhone.matches(
                "^"
                + "[1-9]{2}"
                + "9"
                + "\\d{8}"
                + "$"
        )){
            throw new IllegalArgumentException("\nNúmero de telefone inválido");
        }
    }

    private void validPassword(String password) {
        if (!password.matches(
                "^"
                + "(?=.*[A-Z])" //tem uma maiuscula
                + "(?=.*[^A-Za-z0-9])" //tem caractere especial
                + "(?=(?:.*[A-Za-z]){2,})" // tem duas letras
                + ".{8,}" // tem 8 ou mais caracteres
                + "$"
        )) {
            throw new IllegalArgumentException("\nA senha deve ter ao menos um caractere especial, "
            + "uma letra maiúscula e pelo menos 8 caracteres");
        }
    }

    private void validEmail(String email) {
        if (!email.matches("^"
                + "[A-Za-z0-9._%+-]"
                + "+@[A-Za-z0-9.-]"
                + "+\\.[A-Za-z]{2,}"
                + "$"
        )) {
            throw new IllegalArgumentException("\nE-mail inválido");
        }
    }

    private void validCpfFormat(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        // nao vou botar um validador de verdade, pois
        // sempre teria que botar um cpf valido para testes

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            throw new IllegalArgumentException("\nCPF inválido");
        }
    }


    public void validBirth(LocalDate birth) {
        if (birth.isAfter(LocalDate.now().minusYears(18))){
            throw new IllegalArgumentException("\nDeve ser maior de idade para criar uma conta no site");
        }
    }


}
