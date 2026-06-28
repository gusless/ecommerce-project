package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.payment.*;

import java.math.BigDecimal;

public class PaymentScreen {
    public static void show(Order order){
        PaymentMethod paymentMethod = order.getPaymentMethod();
        BigDecimal cartSubtotal = order.getTotalValue();

        System.out.println("\n=====PAGAMENTO=====");
        if (paymentMethod instanceof BankSlipPayment) {
            System.out.println("Forma: Boleto");
            ((BankSlipPayment) paymentMethod).generate();
        } else if (paymentMethod instanceof CreditCardPayment) {
            System.out.println("Forma: Crédito");
        } else if (paymentMethod instanceof DebitCardPayment) {
            System.out.println("Forma: Débito");
        } else if (paymentMethod instanceof PixPayment) {
            System.out.println("Forma: PIX");
        }

        System.out.println("Valor: R$ " + cartSubtotal);

        System.out.print("1. Pagar\n2. Cancelar\n: ");
        int op = App.SCANNER.nextInt();
        App.SCANNER.nextLine();

        while(op != 1 && op != 2){
            System.out.print("\nEscolha inválida. Tente novamente.\n: ");
            op = App.SCANNER.nextInt();
            App.SCANNER.nextLine();
        }

        if (op == 2) {
            return;
        }

        if (App.getOrderService().payOrder(order)) {
            App.getOrderRepository().update();
            System.out.println("\nPagamento realizado com sucesso.");
        }
    }
}
