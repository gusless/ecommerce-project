package com.lp1.project.domain.order;

import com.lp1.project.domain.address.Address;
import com.lp1.project.domain.cart.Cart;
import com.lp1.project.domain.payment.PaymentMethod;

import java.util.List;

public class OrderService {

    public Order finishOrder(Cart cart, PaymentMethod paymentMethod, Address address){

        // fazer exception se for carrinho ta vazio

        Order order = new Order();

        order.setPaymentMethod(paymentMethod);
        order.setAddress(address);
        order.setItems(convertItems(cart));
        order.setTotalValue(cart.getTotalValue());
        order.setSituation(OrderSituation.ORDER_RECEIVED);

        return order;
    }

    private List<OrderItem> convertItems(Cart cart) {
        return cart.getItems().stream()
                .map(cartItem ->
                        new OrderItem(
                            cartItem.getProduct(),
                            cartItem.getQuantity()))
                .toList();
    }
}
