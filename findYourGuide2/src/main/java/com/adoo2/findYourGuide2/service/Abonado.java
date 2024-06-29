package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Reserva;

public class Abonado implements IEstadoReserva {
    public void pagar(Reserva reserva, Double monto) {
        System.out.println("La reserva ya está paga");
    }

    public void cancelar(Reserva reserva) {
        Cancelado nuevoEstado = new Cancelado();
        reserva.cambiarEstado(nuevoEstado);
    }
}
