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

    OrderSituation(String situation){
        this.situation = situation;
    }

    public String getSituation() {
        return situation;
    }
}
