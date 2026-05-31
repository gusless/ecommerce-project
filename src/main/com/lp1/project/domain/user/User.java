package com.lp1.project.domain.user;

import com.lp1.project.domain.address.Address;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.review.Review;

import java.util.List;
import java.util.Set;

public class User {
    private Address principalAddress;
    private List<Address> addresses;
    private Set<Product> favorites;
}
