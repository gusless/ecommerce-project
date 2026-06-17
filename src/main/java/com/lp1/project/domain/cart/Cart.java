package com.lp1.project.domain.cart;

import com.lp1.project.domain.product.Product;

import java.math.BigDecimal;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    private BigDecimal cartSubtotal;

    @Override
    public String toString() {
        return "Seu Carrinho:\n" +
                items +
                "\nTotal:" + cartSubtotal +
                '\n';
    }

    public void addItem(Product product, int quantity){

        for (CartItem item : items){
            if (item.getProduct().equals(product)){
                item.setQuantity(quantity);
                updateTotalPriceTotal();
                return;
            }
        }

        items.add(new CartItem(product, quantity));
        updateTotalPriceTotal();
    }

    private void updateTotalPriceTotal(){
        cartSubtotal = items.stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public List<CartItem> getItems() {
        return items;
    }

    public BigDecimal getCartSubtotal() {
        return cartSubtotal;
    }
}
