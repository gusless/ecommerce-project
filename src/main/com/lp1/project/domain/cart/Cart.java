package com.lp1.project.domain.cart;

import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.user.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Cart {
    private long id;
    private User user;
    private List<CartItem> items;
    private BigDecimal totalPrice;

}
