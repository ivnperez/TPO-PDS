package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Viaje;

public class ViajeCancelado implements IEstadoViaje {

    @Override
    public void aceptar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("No se puede aceptar el viaje, está cancelado");
    }

    @Override
    public void cancelar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("El viaje ya está cancelado");
    }

    @Override
    public void concretar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("No se puede concretar el viaje, está cancelado");
    }

    @Override
    public void reservar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("No se puede reservar el viaje, está cancelado");
    }
}
