package com.lp1.project.domain.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lp1.project.config.LocalDateAdapter;
import com.lp1.project.domain.user.User;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class JsonRepository<T> {
    protected final Gson gson;
    protected final List<T> items;
    private final String FILE_PATH;
    private final Type type;

    protected JsonRepository(String filePath, Type type){

        this.FILE_PATH = filePath;
        this.type = type;

        gson = new GsonBuilder()
                .registerTypeAdapter(
                        LocalDate.class,
                        new LocalDateAdapter()
                )
                .setPrettyPrinting()
                .create();

        this.items = load();
    }

    public List<T> findAll(){
        return new ArrayList<>(items);
    }

    public void save(T item){
        items.add(item);
        persist();
    }

    protected void persist() {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();

            try (Writer writer = new FileWriter(file)) {
                gson.toJson(items, writer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected List<T> load(){
        File file = new File(FILE_PATH);

        if (!file.exists())
            return new ArrayList<>();

        try (Reader reader = new FileReader(file)){

            List<T> loadedItems = gson.fromJson(reader, this.type);

            return loadedItems == null ?
                    new ArrayList<>() :
                    loadedItems;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
