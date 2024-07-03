package com.adoo2.findYourGuide2.service;

import org.springframework.stereotype.Service;

@Service
public class Stripe {

    public void pagar(Double monto) {
        System.out.println("Pagando factura con Stripe: $" + monto);
    }
}
