package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Reserva;
import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Viaje;

public class Aceptado implements IEstadoViaje {

    @Override
    public void aceptar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("ya se encuentra aceptado");
    }

    @Override
    public void cancelar(Guia guia, Turista turista, Viaje viaje) {
        Disponible estado = new Disponible();
        viaje.setEstadoViaje(estado);
    }

    @Override
    public void concretar(Guia guia, Turista turista, Viaje viaje) {
        IEstadoViaje estado = new Concretado();
        viaje.setEstadoViaje(estado);
    }

    @Override
    public void reservar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("ya se encuentra reservado y aceptado");
    }
}
