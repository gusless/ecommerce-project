package com.lp1.project.config;

import com.google.gson.*;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import com.lp1.project.domain.payment.*;
import com.lp1.project.domain.user.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GsonConfig {
    public static Gson createGson() {

        RuntimeTypeAdapterFactory<User> userAdapter = RuntimeTypeAdapterFactory
                .of(User.class, "_type")
                .registerSubtype(Customer.class, "CUSTOMER")
                .registerSubtype(Admin.class, "ADMIN");

        RuntimeTypeAdapterFactory<PaymentMethod> paymentAdapter =
                RuntimeTypeAdapterFactory
                        .of(PaymentMethod.class, "_type")
                        .registerSubtype(PixPayment.class, "PIX")
                        .registerSubtype(BankSlipPayment.class, "BOLETO")
                        .registerSubtype(CreditCardPayment.class, "CREDIT")
                        .registerSubtype(DebitCardPayment.class, "DEBIT");

        return new GsonBuilder()
                .registerTypeAdapter(
                        LocalDate.class,
                        new LocalDateAdapter()
                )
                .registerTypeAdapter(
                        LocalDateTime.class,
                        new LocalDateTimeAdapter()
                )
                .registerTypeAdapterFactory(userAdapter)
                .registerTypeAdapterFactory(paymentAdapter)
                .setPrettyPrinting()
                .create();
        }
    }

