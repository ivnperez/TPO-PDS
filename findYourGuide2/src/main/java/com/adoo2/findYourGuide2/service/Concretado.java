package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Viaje;

public class Concretado implements IEstadoViaje {

    private Guia guia;
    private Turista turista;

    @Override
    public void aceptar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("el viaje ya concreto");
    }

    @Override
    public void cancelar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("el viaje ya concreto");
    }

    @Override
    public void concretar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("el viaje ya concreto");
    }

    @Override
    public void reservar(Guia guia, Turista turista, Viaje viaje) {
        System.out.println("el viaje ya concreto");
    }
}
