package com.lp1.project.domain.shipping;

import com.lp1.project.domain.repository.TransporterRepository;
import com.lp1.project.domain.user.User;
import com.lp1.project.domain.user.UserRole;

public class TransporterService {
    private final TransporterRepository repository;

    public TransporterService(TransporterRepository repository) {
        this.repository = repository;
    }

    public void createTransporter(User user, Transporter transporter){
        if (!(user.getRole().equals(UserRole.ADMIN))) {
            throw new RuntimeException("\nApenas administradores podem cadastrar produtos.");
        }

        if (repository.findByContact(transporter.getContact()) != null) {
            throw new RuntimeException("\nContato já cadastrado.");
        }

        if (repository.findByName(transporter.getName()) != null){
            throw new RuntimeException("\nTransportadora já existe.");
        }

        if (!(validEmail(transporter.getContact()) || validNumberPhone(transporter.getContact()))) {
            throw new RuntimeException("\nContato inválido.");
        }

        repository.save(transporter);
    }

    private boolean validNumberPhone(String numberPhone) {
        numberPhone = numberPhone.replaceAll("\\D", "");
        return numberPhone.matches(
                "^"
                        + "[1-9]{2}"
                        + "9"
                        + "\\d{8}"
                        + "$"
        );
    }

    private boolean validEmail(String email) {
        return email.matches("^"
                + "[A-Za-z0-9._%+-]"
                + "+@[A-Za-z0-9.-]"
                + "+\\.[A-Za-z]{2,}"
                + "$"
        );
    }

}
