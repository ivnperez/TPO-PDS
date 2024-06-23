package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Factura;
import org.springframework.stereotype.Service;

@Service
public class Impaga implements IEstado {

    @Override
    public void pagar(Factura factura) {
        // Lógica para manejar el pago de una factura impaga
        System.out.println("Pagando factura impaga: " + factura.getId());
        factura.cambiarEstado(new Paga());
    }
}
