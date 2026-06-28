package com.lp1.project.app.forms;

import com.lp1.project.app.App;
import com.lp1.project.domain.address.State;

public class AddAddressForm {
    public static String cep() {
        System.out.print("CEP: ");
        return App.SCANNER.nextLine();
    }

    public static State state() {
        System.out.print("Estado (sigla): ");
        String stateString = App.SCANNER.nextLine();
        return State.fromString(stateString);
    }

    public static String city() {
        System.out.print("Cidade: ");
        return App.SCANNER.nextLine();
    }

    public static String neighborhood() {
        System.out.print("Bairro: ");
        return App.SCANNER.nextLine();
    }

    public static String street() {
        System.out.print("Rua: ");
        return App.SCANNER.nextLine();
    }

    public static String number() {
        System.out.print("Número: ");
        return App.SCANNER.nextLine();
    }

    public static String complement() {
        System.out.print("Complemento (opcional): ");
        return App.SCANNER.nextLine();
    }
}
