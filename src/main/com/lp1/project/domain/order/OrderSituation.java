package com.lp1.project.domain.order;

public enum OrderSituation {
    ORDER_RECEIVED("OrderReceived"),
    SENT("Sent"),
    RECEIVED_BY_TRANSPORTER("ReceivedByTransporter"),
    IN_TRANSIT("InTransit"),
    DELIVERED("Delivered");

    private String situation;

    OrderSituation(String situation){
        this.situation = situation;
    }

    public String getSituation() {
        return situation;
    }
}
