package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.app.forms.CardForm;
import com.lp1.project.domain.payment.*;

public class ChoosePaymentMethodScreen {
    public static PaymentMethod show(){
        System.out.println("\n=====MEIO DE PAGAMENTO=====");
        System.out.print("1. Boleto\n2. Pix\n3. Cartão de crédito\n4. Cartão de débito\n: ");

        int op = App.SCANNER.nextInt();
        App.SCANNER.nextLine();

        String cardNumber;
        String holderName;
        String expirationDate;
        String cvv;
        int installments;

        switch (op){
            case 1: return new BankSlipPayment();
            case 2: return new PixPayment();
            case 3:
                cardNumber = CardForm.cardNumber();
                holderName = CardForm.cardHolderName();
                expirationDate = CardForm.cardExpirationDate();
                cvv = CardForm.cvv();
                installments = CardForm.installments();

                return new CreditCardPayment(cardNumber, holderName, expirationDate, installments);
            case 4:
                cardNumber = CardForm.cardNumber();
                holderName = CardForm.cardHolderName();
                expirationDate = CardForm.cardExpirationDate();

                return new DebitCardPayment(cardNumber, holderName, expirationDate);
            default:
                return null;
        }
    }
}
