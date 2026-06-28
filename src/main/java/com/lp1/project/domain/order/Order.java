package com.lp1.project.domain.order;

import com.lp1.project.app.App;
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
    private Long customerId;
    private PaymentMethod paymentMethod;
    private Address address;
    private List<OrderItem> items;
    private BigDecimal totalValue;
    private OrderSituation situation;
    private Shipping shipping;

    private LocalDateTime dateTimePurchase;

    private static long idCount = 1;

    public Order(Long customerId, PaymentMethod paymentMethod, Address address, List<OrderItem> items,
          BigDecimal totalValue, OrderSituation situation, Shipping shipping){
        this.customerId = customerId;
        this.paymentMethod = paymentMethod;
        this.address = address;
        this.items = items;
        this.situation = situation;
        this.totalValue = totalValue;
        this.shipping = shipping;

        this.dateTimePurchase = LocalDateTime.now();

        this.id = idCount;
        idCount++;

    }

    @Override
    public String toString() {

        return "Pedido " + id + " - "
                + dateTimePurchase.format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")) +
                "\nCliente: " + App.getUserRepository().findById(customerId).getName() +
                "\nMétodo de pagamento: " + paymentMethod +
                "\nProdutos:\n" + items +
                "\nTransportadora:\n" + shipping.getTransporter() +
                " - Frete: R$" + shipping.getShippingValue() +
                "\nTotal: R$" + totalValue +
                "\nSituação: " + situation.getSituation() +
                "\nEndereço:\n " + address;
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

    public Long getCustomerId() {
        return customerId;
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
