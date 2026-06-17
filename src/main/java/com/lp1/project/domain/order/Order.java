package com.lp1.project.domain.order;

import com.lp1.project.domain.address.Address;
import com.lp1.project.domain.payment.PaymentMethod;
import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.shipping.Shipping;
import com.lp1.project.domain.shipping.Transporter;
import com.lp1.project.domain.user.Customer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {
    private long id;
    private Customer customer;
    private PaymentMethod paymentMethod;
    private Address address;
    private List<OrderItem> items;
    private BigDecimal totalValue;
    private OrderSituation situation;
    private Shipping shipping;

    private LocalDateTime dateTimePurchase;

    private static long idCount = 1;

    public Order(Customer customer, PaymentMethod paymentMethod, Address address, List<OrderItem> items,
          BigDecimal totalValue, OrderSituation situation, Shipping shipping){
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.address = address;
        this.items = items;
        this.situation = situation;
        this.totalValue = totalValue;
        this.shipping = shipping;

        this.dateTimePurchase = LocalDateTime.now();

        this.id = idCount;
        idCount++;

        System.out.println("Pedido nº" + this.id + " criado em " +
                dateTimePurchase.format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")));
    }

    public static void synchronizeIdCounter(List<Order> order) {
        long maxId = order.stream()
                .mapToLong(Order::getId)
                .max()
                .orElse(0);

        idCount = maxId + 1;
    }

    public void setSituation(OrderSituation situation) {
        this.situation = situation;
    }

    public long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public Address getAddress() {
        return address;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public LocalDateTime getDateTimePurchase() {
        return dateTimePurchase;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public OrderSituation getSituation() {
        return situation;
    }

}
