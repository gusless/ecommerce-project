package com.lp1.project.domain.shipping;

import com.lp1.project.domain.user.User;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

public class Transporter {
    private long id;
    private String name;
    private BigDecimal shippingFactor;
    private Integer deliveryDaysAdjustment;
    private String contact;
    private URI website;

    private static long idCount = 1;

    public Transporter(String name, BigDecimal shippingFactor, Integer deliveryDaysAdjustment, String contact, URI website) {
        this.name = name;
        this.shippingFactor = shippingFactor;
        this.deliveryDaysAdjustment = deliveryDaysAdjustment;
        this.contact = contact;
        this.website = website;

        this.id = idCount;
        idCount++;

    }

    public static void synchronizeIdCounter(List<Transporter> transporters) {
        long maxId = transporters.stream()
                .mapToLong(Transporter::getId)
                .max()
                .orElse(0);

        idCount = maxId + 1;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getShippingFactor() {
        return shippingFactor;
    }

    public Integer getDeliveryDaysAdjustment() {
        return deliveryDaysAdjustment;
    }

    public String getContact() {
        return contact;
    }

    public URI getWebsite() {
        return website;
    }

    public void setShippingFactor(BigDecimal shippingFactor) {
        this.shippingFactor = shippingFactor;
    }

    public void setDeliveryDaysAdjustment(Integer deliveryDaysAdjustment) {
        this.deliveryDaysAdjustment = deliveryDaysAdjustment;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setWebsite(URI website) {
        this.website = website;
    }
}
