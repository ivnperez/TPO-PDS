package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Reserva;
import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Viaje;

public class Disponible implements IEstadoViaje {

    @Override
    public void aceptar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("no se puede aceptar, ya que no se encuentra en reservado");
    }

    @Override
    public void cancelar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("no se puede cancelar, ya que no se encuentra en reservado o aceptado");
    }

    @Override
    public void concretar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("no se puede concretar, ya que no se encuentra en aceptado");
    }

    @Override
    public void reservar(Guia guia, Turista turista, Viaje viaje) {
        Reservado estado = new Reservado();
        viaje.setEstadoViaje(estado);
    }
}
