package java.com.lp1.project.domain.user;

import java.time.LocalDate;
import java.util.List;


public class User {
    private long id;
    private String name;
    private LocalDate birth;
    private String cpf;
    private String email;
    private String password;
    private String numberPhone;

    private static long idCount = 1;

    public User(String name, LocalDate birth,
                String cpf, String email, String password,
                String numberPhone) {
        this.name = name;
        this.birth = birth;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.numberPhone = numberPhone;

        this.id = idCount;
        idCount++;
    }

    public static void synchronizeIdCounter(List<User> users) {
        long maxId = users.stream()
                .mapToLong(User::getId)
                .max()
                .orElse(0);

        idCount = maxId + 1;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNumberPhone() {
        return numberPhone;
    }
}
