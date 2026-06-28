package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.order.OrderSituation;

import java.util.List;

public class UpdateOrderSituation {
    public static void update() {
        System.out.println("\n=====ATUALIZAR RASTREIO=====");
        List<Order> orders = App.getOrderRepository().findOrdersNotDelivered(App.getSession().getCurrentUser());

        if (orders.isEmpty()) {
            System.out.println("\nNenhum pedido não entregue.");
            App.wait3Seconds();

            SeePreviousOrdersScreen.show();
        }

        System.out.println("Pedidos não entregues:");
        for (Order order : orders) {
            System.out.println(order);
        }

        System.out.print("Digite o id do pedido: ");
        long id = App.SCANNER.nextLong();
        App.SCANNER.nextLine();

        Order order = App.getOrderRepository().findById(id);

        if (order == null) {
            System.out.println("\nPedido não encontrado.");
            App.wait3Seconds();
            return;
        }

        if (!order.getCustomerId().equals(App.getSession().getCurrentUser().getId())) {
            System.out.println("\nNenhum pedido seu com esse id encontrado.");
            App.wait3Seconds();
            return;
        }

        if (order.getSituation() == OrderSituation.ORDER_RECEIVED) {
            System.out.println("\nEsse pedido ainda não foi pago. Pague para conseguir atualizar o rastreio.");
            App.wait3Seconds();
            return;
        }

        if (order.getSituation() == OrderSituation.DELIVERED) {
            System.out.println("\nEsse pedido já foi entregue.");
            App.wait3Seconds();
            return;
        }

        System.out.println("\nSituação anterior: " + order.getSituation().getSituation() +
                "\nSituação atual: " + order.getSituation().next().getSituation());

        order.setSituation(order.getSituation().next());

        App.getOrderRepository().update();

        App.wait3Seconds();
    }
}
