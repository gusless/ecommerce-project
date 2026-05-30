package com.lp1.project.domain.order;

import com.lp1.project.domain.address.Address;
import com.lp1.project.domain.cart.Cart;
import com.lp1.project.domain.payment.PaymentMethod;
import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.transporter.Transporter;
import com.lp1.project.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class Order {
    private long id;
    private User user;
    private Transporter transporter;
    private Address address;
    private List<OrderItem> items;
    private BigDecimal totalValue;
    private BigDecimal shipping;
    private LocalDateTime dateTimePurchase;
    private PaymentMethod paymentFormat;
    private OrderSituation situation;
}
