package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.order.OrderSituation;
import com.lp1.project.domain.payment.BankSlipPayment;
import com.lp1.project.domain.repository.OrderRepository;
import com.lp1.project.domain.user.Customer;

import java.util.List;

public class SeePreviousOrdersScreen {
    public static void show() {
        while(true){
            List<Order> orders = App.getOrderRepository().findOrdersByCustomer(App.getSession().getCurrentUser());

            System.out.println("\n=====PEDIDOS=====");

            if (orders.isEmpty()) {
                System.out.println("\nVocê não tem nenhum pedido");
                System.out.println("1. Fazer pedido\n2. Voltar");
                System.out.print(": ");

                int op = App.SCANNER.nextInt();
                App.SCANNER.nextLine();

                switch (op) {
                    case 1 -> NewOrderScreen.show();
                    case 2 -> CustomerMainScreen.show();
                    default -> {
                        System.out.println("\nOpção inválida. Tente novamente.");
                        continue;
                    }
                }
            }

            for (Order order : orders) {
                System.out.println(order);
            }

            System.out.print("1. Atualizar rastreio\n2. Pagar pedido\n3. Fazer review de pedido\n4. Voltar\n: ");

            int op = App.SCANNER.nextInt();
            App.SCANNER.nextLine();

            switch (op) {
                case 1 -> UpdateOrderSituation.update();
                case 2 -> PayOrderScreen.pay();
//            case 3 -> MakeOrderReview.review();
            }
        }
    }
}
