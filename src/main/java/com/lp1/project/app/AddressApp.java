package com.lp1.project.app;

import com.lp1.project.domain.address.Address;
import com.lp1.project.domain.address.State;

import java.util.Scanner;

public class AddressApp {

    public static void testAddress() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCadastrar Endereço:");

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.println("\nEstados:");

        for (State state : State.values()) {
            System.out.println(
                    state.getAcronym() + " - " + state.getName()
            );
        }
        State state;

        while (true) {
            try {
                System.out.print("\nSeu estado(sigla): ");
                state = State.valueOf(
                        scanner.nextLine().toUpperCase()
                );
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Estado não encontrado, tente novamente");
            }
        }

        System.out.print("Cidade: ");
        String city = scanner.nextLine();

        System.out.print("Bairro: ");
        String neighbor = scanner.nextLine();

        System.out.print("Rua: ");
        String street = scanner.nextLine();

        System.out.print("Número: ");
        String number = scanner.nextLine();

        System.out.print("Complemento: ");
        String complement = scanner.nextLine();

        Address address = new Address(cep, state, city, neighbor, street, number, complement);

        System.out.println("\nEndereço cadastrado");
        System.out.println(address);
    }
}