package com.lp1.project.domain.repository;


import com.google.gson.reflect.TypeToken;
import com.lp1.project.domain.shipping.Transporter;

import java.util.List;

public class TransporterRepository extends JsonRepository<Transporter> {

    private static final String FILE_PATH = "data/transporters.json";

    public TransporterRepository() {
        super(FILE_PATH, new TypeToken<List<Transporter>>(){}.getType());
        Transporter.synchronizeIdCounter(findAll());
    }

    public Transporter findById(long id){
        return items.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Transporter findByName(String name){
        return items.stream()
                .filter(t -> t.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
