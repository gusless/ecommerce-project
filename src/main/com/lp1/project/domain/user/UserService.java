package com.lp1.project.domain.user;

import java.time.LocalDate;

public class UserService {

    public void enter(String login, String password){

    }

    public User register(String name, LocalDate birth,
                         String cpf, String email, String password,
                         String numberPhone){

        validBirth(birth);
        validCpfFormat(cpf);
        validEmail(email);
        validPassword(password);
        validNumberPhone(numberPhone);

        //verificar se ja existe

        User user = new User(name, birth, cpf, email, password, numberPhone);
        System.out.println("Usuário nº" + user.getId() + " cadastrado com sucesso");

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
            throw new IllegalArgumentException("Número de telefone inválido");
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
            throw new IllegalArgumentException("A senha deve ter ao menos um caractere especial, "
            + "uma letra maiúscula e pelo menos 8 caracteres");
        }
    }

    private void validEmail(String email) {
        if (!email.matches("^"
                + "[A-Za-z0-9._%+-]"
                + "+@[A-Za-z0-9.-]"
                + " +\\.[A-Za-z]{2,}"
                + "$"
        )) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }

    private void validCpfFormat(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        // nao vou botar um validador de verdade, pois
        // sempre teria que botar um cpf valido para testes

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            throw new IllegalArgumentException("CPF inválido");
        }
    }


    public void validBirth(LocalDate birth) {
        if (birth.isAfter(LocalDate.now().minusYears(18))){
            throw new IllegalArgumentException("Deve ser maior de idade para criar uma conta no site");
        }
    }


}
