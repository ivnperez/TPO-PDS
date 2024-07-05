package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Viaje;

public class Reservado implements IEstadoViaje {

    private Guia guiaReservado;
    private Turista turista;

    @Override
    public void aceptar(Guia guia, Turista turista, Viaje viaje) {
        Aceptado estado = new Aceptado();
        viaje.setEstadoViaje(estado);
        viaje.setEstado("Aceptado");
    }

    @Override
    public void cancelar(Guia guia, Turista turista, Viaje viaje) {
        Disponible estado = new Disponible();
        viaje.setEstadoViaje(estado);
    }

    @Override
    public void concretar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("no se puede concretar, ya que no se encuentra en aceptado");
    }

    @Override
    public void reservar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("ya se encuentra en reservado");
    }
}
