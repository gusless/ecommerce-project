package com.lp1.project.domain.order;

import com.lp1.project.app.App;
import com.lp1.project.domain.address.Address;
import com.lp1.project.domain.cart.Cart;
import com.lp1.project.domain.payment.*;
import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.repository.OrderRepository;
import com.lp1.project.domain.shipping.Shipping;
import com.lp1.project.domain.user.Customer;
import com.lp1.project.domain.user.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order finishOrder(Customer customer, Cart cart, PaymentMethod paymentMethod,
                             Address address, Shipping shipping){

        if (cart.getItems().isEmpty())
            throw new IllegalArgumentException("O carrinho não pode estar vazio");

        BigDecimal totalValue = calculateTotalValue(
                cart.getCartSubtotal(),
                shipping.getShippingValue(),
                paymentMethod
        );

        Order order = new Order(customer.getId(), paymentMethod, address, convertItems(cart), totalValue,
                OrderSituation.ORDER_RECEIVED, shipping);

        repository.save(order);

        return order;
    }

    private BigDecimal calculateTotalValue(
            BigDecimal cartSubtotal,
            BigDecimal shippingValue,
            PaymentMethod paymentMethod) {

        BigDecimal tax = BigDecimal.ZERO,
                discount = BigDecimal.ZERO;

        if (paymentMethod instanceof PixPayment) {
            discount = calculatePercent(cartSubtotal, BigDecimal.valueOf(15));

        } else if (paymentMethod instanceof DebitCardPayment ||
                paymentMethod instanceof BankSlipPayment) {
            discount = calculatePercent(cartSubtotal, BigDecimal.valueOf(10));

        } else if (paymentMethod instanceof CreditCardPayment) {
            CreditCardPayment credCard = (CreditCardPayment) paymentMethod;
            int installments = credCard.getInstallments();

            if (installments < 1 || installments > 12){
                throw new IllegalArgumentException("Deve-se entre 1 a 12 parcelas.");

            } else if (installments == 1){
                discount = calculatePercent(cartSubtotal, BigDecimal.valueOf(15));

            } else if (installments > 6) {
                BigDecimal tax_amount = BigDecimal.valueOf(2);
                for (int i = 8; i <= installments; i++){
                    tax_amount = tax_amount.add(BigDecimal.valueOf(0.25));
                }
                tax = calculatePercent(cartSubtotal, tax_amount);
            }

        }
        return cartSubtotal
                .add(shippingValue)
                .add(tax)
                .subtract(discount);

    }

    private BigDecimal calculatePercent(BigDecimal value, BigDecimal percent) {
        return (value
                .multiply(percent)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
    }

    public boolean payOrder(Order order){
        boolean success = order.getPaymentMethod()
                .processPayment(order.getTotalValue());
        if (success){
            order.setSituation(OrderSituation.PAID);

            for(OrderItem item : order.getItems()){
                Product product = item.getProduct();

                product.decreaseStockQuantity(item.getQuantity());
            }

            repository.update();
            App.getProductRepository().update();
        }


        return success;
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
