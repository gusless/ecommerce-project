package com.lp1.project.domain.user;

import java.time.LocalDate;

public class Admin extends User{
    public Admin(String name, LocalDate birth, String cpf, String email, String password, String numberPhone) {
        super(name, birth, cpf, email, password, numberPhone);
    }
}
