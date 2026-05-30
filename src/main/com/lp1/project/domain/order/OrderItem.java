package com.lp1.project.domain.order;

import com.lp1.project.domain.product.Product;

import java.math.BigDecimal;

public class OrderItem {
    private Product product;
    private Integer quantity;
    private BigDecimal subtotal;
}
