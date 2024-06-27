package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Factura;
import org.springframework.stereotype.Service;

@Service
public class Impaga implements IEstado {

    private Stripe stripe;

    @Override
    public void pagar(Factura factura) {
        stripe.pagar(factura);
        System.out.println("Pagando factura impaga: " + factura.getId());
        factura.cambiarEstado(new Paga());
    }
}
