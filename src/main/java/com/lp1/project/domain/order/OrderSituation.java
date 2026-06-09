package java.com.lp1.project.domain.order;

public enum OrderSituation {
    ORDER_RECEIVED("OrderReceived"),
    PAID("Paid"),
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
