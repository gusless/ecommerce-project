package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.app.forms.AddAddressForm;
import com.lp1.project.domain.address.Address;
import com.lp1.project.domain.address.State;
import com.lp1.project.domain.repository.UserRepository;
import com.lp1.project.domain.user.Customer;

public class AddAddressScreen {
    private static final UserRepository repository = App.getUserRepository();
    public static void show(){
        System.out.println("\n=====NOVO ENDEREÇO=====");

        Customer user = (Customer) App.getSession().getCurrentUser();

        String cep = AddAddressForm.cep();
        State state = AddAddressForm.state();
        String city = AddAddressForm.city();
        String neighborhood = AddAddressForm.neighborhood();
        String street = AddAddressForm.street();
        String number = AddAddressForm.number();
        String complement = AddAddressForm.complement();

        Address newAddress = new Address(cep, state, city, neighborhood, street, number, complement);

        if (user.getPrincipalAddress() == null) {
            user.setPrincipalAddress(newAddress);
        }

        user.addAddress(newAddress);

        repository.update();
    }
}
