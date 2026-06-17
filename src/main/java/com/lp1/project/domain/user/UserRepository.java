package com.lp1.project.domain.user;

import java.time.LocalDate;
import com.lp1.project.config.LocalDateAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final String FILE_PATH = "data/users.json";

    private final Gson gson;
    private List<User> users;

    public UserRepository() {
        gson = new GsonBuilder()
                .registerTypeAdapter(
                        LocalDate.class,
                        new LocalDateAdapter()
                )
                .setPrettyPrinting()
                .create();

        users = load();
    }

    public List<User> findAll(){
        return new ArrayList<>(users);
    }

    public User findById(long id){
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User findByEmail(String email){
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public User findByCPF(String cpf){
        return users.stream()
                .filter(u -> u.getCpf().equalsIgnoreCase(cpf))
                .findFirst()
                .orElse(null);
    }

    public void save(User user){
        users.add(user);
        persist();
    }

    private void persist() {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();

            try (Writer writer = new FileWriter(file)) {
                gson.toJson(users, writer);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar usuários", e);
        }
    }

    private List<User> load(){
        File file = new File(FILE_PATH);

        if (!file.exists())
            return new ArrayList<>();

        try (Reader reader = new FileReader(FILE_PATH)){

            Type type = new TypeToken<List<User>>() {}.getType();

            List<User> loadedUsers = gson.fromJson(reader, type);

            if (loadedUsers == null)
                return new ArrayList<>();

            User.synchronizeIdCounter(loadedUsers);

            return loadedUsers;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar usuários", e);
        }
    }
}
