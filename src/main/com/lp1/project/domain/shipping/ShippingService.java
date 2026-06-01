package com.lp1.project.domain.shipping;

import com.lp1.project.domain.address.Address;
import com.lp1.project.domain.address.State;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShippingService {

    public ShippingInfos calculateShippingAndDeliveryTime(Address address, Transporter transporter, BigDecimal totalWeight){
        State destination = address.getState();
        ShippingInfos baseShipping = calculateStateShipping(destination);
        return new ShippingInfos(
                baseShipping.value()
                        .add(calculateShippingByWeight(totalWeight))
                        .multiply(transporter.getShippingFactor())
                        .setScale(2, RoundingMode.HALF_UP),
                baseShipping.days() + transporter.getDeliveryDaysAdjustment()
        );

    }

    private ShippingInfos calculateStateShipping(State destination){
        switch (destination) {
            // acre
            case AC:
                return new ShippingInfos(BigDecimal.valueOf(40), 20);
            // norte menos acre
            case AP:
            case AM:
            case PA:
            case RO:
            case RR:
            case TO:
                return new ShippingInfos(BigDecimal.valueOf(25), 15);
            // nordeste
            case AL:
            case BA:
            case CE:
            case MA:
            case PB:
            case PE:
            case PI:
            case RN:
            case SE:
                return new ShippingInfos(BigDecimal.valueOf(20), 10);
                // centro-oeste
            case DF:
            case GO:
            case MT:
            case MS:
                return new ShippingInfos(BigDecimal.valueOf(15), 5);
                // sudeste
            case ES:
            case MG:
            case RJ:
            case SP:
                return new ShippingInfos(BigDecimal.valueOf(0), 2);
                // sul
            case PR:
            case RS:
            case SC:
                return new ShippingInfos(BigDecimal.valueOf(0), 3);

            default:
                throw new IllegalArgumentException(
                        "Estado não suportado");
        }
    }

    private BigDecimal calculateShippingByWeight(BigDecimal totalWeight) {
        if (totalWeight.compareTo(BigDecimal.valueOf(10)) <= 0){
            return BigDecimal.ZERO;

        } else if (totalWeight.compareTo(BigDecimal.valueOf(20)) <= 0){
            return BigDecimal.valueOf(15);

        } else {
            return BigDecimal.valueOf(25);

        }
    }

}
