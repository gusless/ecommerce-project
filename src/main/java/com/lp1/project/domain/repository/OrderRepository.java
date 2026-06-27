package com.lp1.project.domain.repository;

import com.google.gson.reflect.TypeToken;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.user.Customer;
import com.lp1.project.domain.user.User;

import java.lang.reflect.Type;
import java.util.List;

public class OrderRepository extends JsonRepository<Order> {

    private static final String FILE_PATH = "data/orders.json";

    public OrderRepository() {
        super(FILE_PATH, new TypeToken<List<Order>>(){}.getType());
        Order.synchronizeIdCounter(findAll());
    }

    public Order findById(long id){
        return items.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Order> findOrdersByCustomer(User customer){
        return items.stream()
                .filter(t -> t.getCustomer() != null
                        && t.getCustomer().equals(customer))
                .toList();
    }

}
