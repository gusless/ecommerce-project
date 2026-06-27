package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.app.forms.NewOrderForm;
import com.lp1.project.domain.cart.Cart;
import com.lp1.project.domain.order.OrderService;
import com.lp1.project.domain.product.Product;

public class NewOrderScreen {
    private static final OrderService service = App.getOrderService();

    public static void show() {
        while(true){
            try {
                System.out.println("\n=====NOVO PEDIDO=====");
                Cart cart = new Cart();

                while(true){
                    Product cartProduct = NewOrderForm.product();
                    int quantity = NewOrderForm.quantity(cartProduct);

                    if (quantity > 0 && cartProduct.getStockQuantity() >= quantity) {
                        cart.addItem(cartProduct, quantity);
                    } else {
                        System.out.println("\nQuantidade inválida. Tente adicionar o produto novamente no carrinho.");
                        continue;
                    }

                    System.out.println(cart);

                    System.out.println("1. Finalizar carrinho\n2. Continuar comprando");

                    int op = App.SCANNER.nextInt();
                    App.SCANNER.nextLine();

                    if (op == 2) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
