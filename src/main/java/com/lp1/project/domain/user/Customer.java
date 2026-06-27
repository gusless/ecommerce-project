package com.lp1.project.domain.user;

import com.lp1.project.domain.address.Address;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.review.Review;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Customer extends User {
    private Address principalAddress;
    private List<Address> addresses;
    private Set<Product> favorites;
    private List<Order> orders;
    private List<Review> reviews;

    public Customer(String name, LocalDate birth, String cpf, String email, String password, String numberPhone) {
        super(name, birth, cpf, email, password, numberPhone);
        setRole(UserRole.CUSTOMER);

        addresses = new ArrayList<>();
        favorites = new HashSet<>();
        orders = new ArrayList<>();
        reviews = new ArrayList<>();
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public Address getPrincipalAddress() {
        return principalAddress;
    }

    public void setPrincipalAddress(Address principalAddress) {
        this.principalAddress = principalAddress;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Set<Product> getFavorites() {
        return favorites;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
