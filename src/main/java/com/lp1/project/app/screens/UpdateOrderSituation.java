package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.order.OrderSituation;

public class UpdateOrderSituation {
    public static void update() {
        System.out.println("\n=====ATUALIZAR RASTREIO=====");

        System.out.print("Digite o id do pedido: ");
        long id = App.SCANNER.nextLong();
        App.SCANNER.nextLine();

        Order order = App.getOrderRepository().findById(id);

        if (order == null) {
            System.out.println("\nPedido não encontrado.");
            return;
        }

        if (!order.getCustomerId().equals(App.getSession().getCurrentUser().getId())) {
            System.out.println("\nNenhum pedido seu com esse id encontrado.");
            return;
        }

        if (order.getSituation() == OrderSituation.ORDER_RECEIVED) {
            System.out.println("\nEsse pedido ainda não foi pago. Pague para conseguir atualizar o rastreio.");
            return;
        }

        if (order.getSituation() == OrderSituation.DELIVERED) {
            System.out.println("\nEsse pedido já foi entregue.");
            return;
        }

        System.out.println("\nSeu pedido estava em " + order.getSituation().getSituation() +
                " e agora está em " + order.getSituation().next().getSituation());

        order.setSituation(order.getSituation().next());

        App.getOrderRepository().update();
    }
}
