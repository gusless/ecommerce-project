package com.lp1.project.domain.repository;

import com.google.gson.reflect.TypeToken;
import com.lp1.project.app.App;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.order.OrderSituation;
import com.lp1.project.domain.review.Review;
import com.lp1.project.domain.user.Customer;
import com.lp1.project.domain.user.User;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderRepository extends JsonRepository<Order> {

    private static final String FILE_PATH = "data/orders.json";

    public OrderRepository() {
        super(FILE_PATH, new TypeToken<List<Order>>(){}.getType());
        Order.synchronizeIdCounter(findAll());
    }

    public Order findById(long id){
        return items.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Order> findOrdersByCustomer(User customer){
        return items.stream()
                .filter(o -> o.getCustomerId() != null
                        && o.getCustomerId().equals(customer.getId()))
                .toList();
    }

    public List<Order> findOrdersWithoutReview(Customer customer) {
        List<Order> orders = findOrdersByCustomer(customer);
        List<Review> allReviews = App.getReviewRepository().findAll();

        Set<Long> reviewedProducts = allReviews.stream()
                .filter(r -> r.getUser().getId() == customer.getId())
                .map(r -> r.getProduct().getId())
                .collect(Collectors.toSet());

        return orders.stream()
                .filter(o -> o.getItems().stream()
                        .noneMatch(item ->
                                reviewedProducts.contains(item.getProduct().getId())
                        )
                )
                .toList();
    }

    public List<Order> findOrdersNotDelivered(User customer){
        return items.stream()
                .filter(o -> o.getCustomerId() == customer.getId()
                        && o.getSituation() != OrderSituation.DELIVERED)
                .toList();
    }

    public List<Order> findOrdersNotPaid(User customer){
        List<Order> orders = findOrdersByCustomer(customer);

        return items.stream()
                .filter(o -> o.getCustomerId() == customer.getId()
                        && o.getSituation() == OrderSituation.ORDER_RECEIVED)
                .toList();
    }
}
