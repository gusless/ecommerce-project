package com.lp1.project.domain.cart;

import com.lp1.project.domain.product.Product;

import java.math.BigDecimal;

public class CartItem {
    private Product product;
    private Integer quantity;
    private BigDecimal subtotal;

    public CartItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;

        subtotal = product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public String toString() {
        return product.getName() + " - Quantidade: " + quantity +
                " - R$" + subtotal + "\n";
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
