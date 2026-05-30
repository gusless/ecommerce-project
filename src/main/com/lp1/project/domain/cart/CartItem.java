package com.lp1.project.domain.cart;

import com.lp1.project.domain.product.Product;

import java.math.BigDecimal;

public class CartItem {
    private Product product;
    private Integer quantity;
    private BigDecimal subtotal;
}
