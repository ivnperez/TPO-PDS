package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Factura;
import org.springframework.stereotype.Service;

@Service
public class Paga implements IEstado {

    @Override
    public void pagar(Factura factura) {
        // Lógica para manejar una factura ya pagada
        System.out.println("La factura ya está pagada: " + factura.getId());
    }
}
