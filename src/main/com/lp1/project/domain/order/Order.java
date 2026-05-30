package com.lp1.project.domain.order;

import com.lp1.project.domain.address.Address;
import com.lp1.project.domain.payment.PaymentMethod;
import com.lp1.project.domain.transporter.Transporter;
import com.lp1.project.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private long id;
    private User user;
    private Transporter transporter;
    private Address address;
    private List<OrderItem> items;
    private BigDecimal totalValue;
    private BigDecimal shipping;
    private LocalDateTime dateTimePurchase;
    private PaymentMethod paymentMethod;
    private OrderSituation situation;

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Transporter getTransporter() {
        return transporter;
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

    public BigDecimal getShipping() {
        return shipping;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setTransporter(Transporter transporter) {
        this.transporter = transporter;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    public void setDateTimePurchase(LocalDateTime dateTimePurchase) {
        this.dateTimePurchase = dateTimePurchase;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setSituation(OrderSituation situation) {
        this.situation = situation;
    }
}
