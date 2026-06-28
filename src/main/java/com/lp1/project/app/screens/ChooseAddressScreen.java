package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.address.Address;
import com.lp1.project.domain.user.Customer;

import java.util.List;

public class ChooseAddressScreen {
    public static Address show() {
        System.out.println("\n=====ENDEREÇO DE ENTREGA=====");
        Customer customer = (Customer) App.getSession().getCurrentUser();
        List<Address> addresses = customer.getAddresses();

        if (addresses.isEmpty()) {
            System.out.println("\nNenhum endereço cadastrado.\nCadastre um novo:");
            AddAddressScreen.show();
        }

        System.out.println("\nEndereços:");
        for (int i = 0; i<addresses.size();i++){
            System.out.println(i+1 + ". " + addresses.get(i));
        }

        System.out.print("Escolha o endereço ou aperte 0 para adicionar um novo: ");
        int op = App.SCANNER.nextInt();
        App.SCANNER.nextLine();

        if (op == 0){
            AddAddressScreen.show();
        } else if(op < 1 || op > addresses.size()){
            throw new IllegalArgumentException("\nEndereço inválido.");
        }

        return addresses.get(op-1);
    }
}
