package com.lp1.project.domain.order;

import com.lp1.project.domain.product.Product;

import java.math.BigDecimal;

public class OrderItem {
    private Product product;
    private Integer quantity;
    private BigDecimal subtotal;

    OrderItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;

        subtotal = product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

}
