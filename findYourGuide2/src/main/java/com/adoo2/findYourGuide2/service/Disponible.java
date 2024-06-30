package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Reserva;
import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Viaje;

public class Disponible implements IEstadoViaje {

    @Override
    public void aceptar(Guia guia, Turista turista, Viaje viaje) {
        // Reserva reserva = new Reserva();
        // viaje.setReserva(reserva);
        // IEstadoViaje estado = new Reservado();
        // viaje.setEstadoViaje(estado);
    }

    @Override
    public void cancelar(Guia guia, Turista turista, Viaje viaje) {
        IEstadoViaje estado = new ViajeCancelado();
        viaje.setEstadoViaje(estado);
    }

    @Override
    public void concretar(Guia guia, Turista turista, Viaje viaje) {
        // Lógica para concretar un viaje disponible
    }

    @Override
    public void reservar(Guia guia, Turista turista, Viaje viaje) {
        Reserva reserva = viaje.getReserva();
        reserva.pagar(viaje.getAnticipo());
    }
}
