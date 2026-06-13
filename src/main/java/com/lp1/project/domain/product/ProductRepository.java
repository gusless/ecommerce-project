package com.lp1.project.domain.product;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
   private static final String FILE_PATH = "data/products.json";

   private final Gson gson;
   private List<Product> products;

   public ProductRepository() {
       gson = new GsonBuilder()
               .setPrettyPrinting()
               .create();

       products = load();
   }

   public List<Product> findAll() { return new ArrayList<>(products); }

    public Product findById(long id) {
       return products.stream()
               .filter(p -> p.getId() == id)
               .findFirst()
               .orElse(null);
    }

    public Product findByName(String name) {
       return products.stream()
               .filter(p -> p.getName().equalsIgnoreCase(name))
               .findAny()
               .orElse(null);
    }

    public void save(Product product) {
       if (findByName(product.getName()) != null)
           throw new RuntimeException("Produto já existe.");

       products.add(product);
       persist();
    }

    public void persist() {
       try (Writer writer = new FileWriter(FILE_PATH)) {
           gson.toJson(products, writer);
       } catch (Exception e) {
           throw new RuntimeException("Erro ao salvar produto");
       }
    }

    private List<Product> load() {
       File file = new File(FILE_PATH);

       if(!file.exists())
           return new ArrayList<>();


       try (Reader reader = new FileReader(FILE_PATH)) {
           Type type = new TypeToken<List<Product>>() {}.getType();
           List<Product> loadedProducts = gson.fromJson(reader, type);

           if (loadedProducts == null)
               return new ArrayList<>();

           Product.synchronizeIdCounter(loadedProducts);

           return loadedProducts;
       } catch (Exception e) {
           throw new RuntimeException("Erro ao carregar produtos.");
       }
    }
}
