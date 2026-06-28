package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.app.forms.NewOrderForm;
import com.lp1.project.domain.address.Address;
import com.lp1.project.domain.cart.Cart;
import com.lp1.project.domain.cart.CartItem;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.order.OrderService;
import com.lp1.project.domain.payment.PaymentMethod;
import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.shipping.Shipping;
import com.lp1.project.domain.shipping.Transporter;
import com.lp1.project.domain.user.Customer;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NewOrderScreen {
    private static final OrderService service = App.getOrderService();

    public static void show() {
        while(true){
            try {
                System.out.println("\n=====NOVO PEDIDO=====");
                Cart cart = new Cart();

                while(true) {
                    Product cartProduct = NewOrderForm.product();
                    if (cartProduct == null) return;

                    int quantity = NewOrderForm.quantity(cartProduct);

                    if(quantity == 0){
                        continue;
                    } else if (quantity > 0 && cartProduct.getStockQuantity() >= quantity) {
                        cart.addItem(cartProduct, quantity);
                    } else {
                        System.out.println("\nQuantidade inválida. Tente adicionar o produto novamente no carrinho.");
                    }

                    System.out.println(cart);

                    System.out.print("1. Finalizar carrinho\n2. Continuar comprando\n: ");

                    int op = App.SCANNER.nextInt();
                    App.SCANNER.nextLine();

                    while(op != 1 && op != 2) {
                        System.out.print("\nEscolha inválida. Tente novamente.\n: ");
                        op = App.SCANNER.nextInt();
                        App.SCANNER.nextLine();
                    }

                    if (op == 1) {
                        break;
                    }
                }

                Customer customer = (Customer) App.getSession().getCurrentUser();
                PaymentMethod paymentMethod = ChoosePaymentMethodScreen.show();
                Address address = ChooseAddressScreen.show();
                Transporter transporter = ChooseTransporterScreen.show();
                List<CartItem> cartItem = cart.getItems();

                Float totalWeight = 0f;

                for (CartItem item: cartItem) {
                    totalWeight += item.getWeight();
                }

                Shipping shipping = new Shipping(transporter, address, new BigDecimal(totalWeight));

                Order order = service.finishOrder(customer, cart, paymentMethod, address, shipping);

                System.out.println("\nPedido nº" + order.getId() + " criado em " +
                        order.getDateTimePurchase().format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")));

                PaymentScreen.show(order);

                customer.addOrder(order.getId());

                App.getUserRepository().update();

                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
