package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Factura;
import org.springframework.stereotype.Service;

@Service
public class Stripe {

    public void pagar(Factura factura) {
        System.out.println("Pagando factura con Stripe: " + factura.getId());
    }
}
