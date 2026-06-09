package java.com.lp1.project.domain.shipping;

import java.com.lp1.project.domain.address.Address;

import java.math.BigDecimal;

public class Shipping {
    private Transporter transporter;
    private Address address;
    private BigDecimal totalWeight;
    private BigDecimal shippingValue;
    private Integer averageDeliveryTime;


    public Shipping(Transporter transporter, Address address, BigDecimal totalWeight){
        this.transporter = transporter;
        this.address = address;
        this.totalWeight = totalWeight;

        ShippingService shippingService = new ShippingService();
        ShippingInfos shippingInfos = shippingService.calculateShippingAndDeliveryTime(
                address, transporter, totalWeight
        );

        this.shippingValue = shippingInfos.value();
        this.averageDeliveryTime = shippingInfos.days();

    }

    public Transporter getTransporter() {
        return transporter;
    }

    public Address getAddress() {
        return address;
    }

    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    public BigDecimal getShippingValue() {
        return shippingValue;
    }

    public Integer getAverageDeliveryTime() {
        return averageDeliveryTime;
    }
}
