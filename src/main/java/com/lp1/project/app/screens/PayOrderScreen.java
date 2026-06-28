package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.order.OrderSituation;
import com.lp1.project.domain.payment.BankSlipPayment;

import java.util.List;

public class PayOrderScreen {
    public static void pay() {
        System.out.println("\n=====PAGAR PEDIDO=====");
        List<Order> orders = App.getOrderRepository().findOrdersNotPaid(App.getSession().getCurrentUser());

        if(orders.isEmpty()){
            System.out.println("\nNenhum pedido não pago.");
            App.wait3Seconds();
            SeePreviousOrdersScreen.show();
        }

        for (Order order : orders) {
            System.out.println(order);
        }

        System.out.print("\nDigite o id do pedido: ");
        long id = App.SCANNER.nextLong();
        App.SCANNER.nextLine();

        Order order = App.getOrderRepository().findById(id);

        if (order == null) {
            System.out.println("\nPedido não encontrado.");
            App.wait3Seconds();
            SeePreviousOrdersScreen.show();
        }

        if (!order.getCustomerId().equals(App.getSession().getCurrentUser().getId())) {
            System.out.println("\nNenhum pedido seu com esse id encontrado.");
            App.wait3Seconds();
            SeePreviousOrdersScreen.show();
        }

        if (order.getSituation() != OrderSituation.ORDER_RECEIVED) {
            System.out.println("\nEsse pedido já foi pago.");
            App.wait3Seconds();
            SeePreviousOrdersScreen.show();
        }

        if (order.getPaymentMethod() instanceof BankSlipPayment) {
            ((BankSlipPayment) order.getPaymentMethod()).generate();
        }

        if (App.getOrderService().payOrder(order)) {
            App.getOrderRepository().update();
            System.out.println("\nPagamento realizado com sucesso.");
        }
    }
}
