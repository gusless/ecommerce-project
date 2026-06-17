package com.lp1.project.domain.repository;

import com.google.gson.reflect.TypeToken;
import com.lp1.project.domain.user.User;

import java.util.List;

public class UserRepository extends JsonRepository<User> {

    private static final String FILE_PATH = "data/users.json";

    public UserRepository() {
        super(FILE_PATH, new TypeToken<List<User>>(){}.getType());
        User.synchronizeIdCounter(findAll());
    }


    public User findById(long id){
        return items.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User findByEmail(String email){
        return items.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public User findByCPF(String cpf){
        return items.stream()
                .filter(u -> u.getCpf().equalsIgnoreCase(cpf))
                .findFirst()
                .orElse(null);
    }

}
