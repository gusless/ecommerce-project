package com.lp1.project.domain.order;

public enum OrderSituation {
    ORDER_RECEIVED("Pedido recebido"),
    PAID("Pago"),
    SENT("Enviado"),
    RECEIVED_BY_TRANSPORTER("Recebido pela transportadora"),
    IN_TRANSIT("Em trânsito"),
    DELIVERY_ROUTE("Em rota de entrega"),
    DELIVERED("Entregue");

    private String situation;

    public OrderSituation next() {
        return switch (this) {
            case ORDER_RECEIVED -> PAID; 
            case PAID -> SENT;
            case SENT -> RECEIVED_BY_TRANSPORTER;
            case RECEIVED_BY_TRANSPORTER -> IN_TRANSIT;
            case IN_TRANSIT -> DELIVERY_ROUTE;
            case DELIVERY_ROUTE -> DELIVERED;
            case DELIVERED -> DELIVERED;
        };
    }

    public void advanceSituation() {
        if (this == DELIVERED) {
            throw new RuntimeException("\nPedido já foi entregue.");
        }

        this.situation = next().name();
    }

    OrderSituation(String situation){
        this.situation = situation;
    }

    public String getSituation() {
        return situation;
    }
}
