package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Viaje;

public class Reservado implements IEstadoViaje {

    private Guia guiaReservado;
    private Turista turista;

    @Override
    public void aceptar(Guia guia, Turista turista, Viaje viaje) {
        // Lógica para aceptar un viaje reservado
    }

    @Override
    public void cancelar(Guia guia, Turista turista, Viaje viaje) {
        // Lógica para cancelar un viaje reservado
    }

    @Override
    public void concretar(Guia guia, Turista turista, Viaje viaje) {
        // Lógica para concretar un viaje reservado
    }

    @Override
    public void reservar(Guia guia, Turista turista, Viaje viaje) {
        // Lógica para reservar un viaje reservado
    }
}
