package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.order.OrderSituation;
import com.lp1.project.domain.payment.BankSlipPayment;

public class PayOrderScreen {
    public static void pay() {
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

        if (order.getSituation() != OrderSituation.ORDER_RECEIVED) {
            System.out.println("\nEsse pedido já foi pago.");
            return;
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
