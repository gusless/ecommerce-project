package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.user.Customer;

import java.util.List;

public class SeePreviousOrdersScreen {
    public static void show() {
        List<Order> orders = App.getOrderRepository().findOrdersByCustomer(App.getSession().getCurrentUser());

        if (orders.isEmpty()) {
            System.out.println("\nVocê não tem nenhum pedido");
            System.out.println("1. Fazer pedido\n2. Voltar");
            System.out.print(": ");

            int op = App.SCANNER.nextInt();
            App.SCANNER.nextLine();

            switch (op) {
                case 1 -> NewOrderScreen.show();
                case 2 -> CustomerMainScreen.show();
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        for (Order order : orders) {
            System.out.println(order);
        }

        System.out.println("1. Fazer review de pedido\n2. Voltar");
        System.out.print(": ");

    }
}
