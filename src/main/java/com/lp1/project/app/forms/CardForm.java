package com.lp1.project.app.forms;

import com.lp1.project.app.App;

public class CardForm {
    public static String cardNumber() {
        System.out.print("Número do cartão: ");
        return App.SCANNER.nextLine();
    }

    public static String cardHolderName() {
        System.out.print("Nome do titular: ");
        return App.SCANNER.nextLine();
    }

    public static String cardExpirationDate() {
        System.out.print("Data de expiração (MM-YY): ");
        return App.SCANNER.nextLine();
    }

    public static Integer installments() {
        System.out.print("Parcelas: ");
        return App.SCANNER.nextInt();
    }

    public static String cvv() {
        System.out.print("CVV: ");
        return App.SCANNER.nextLine();
    }
}
