package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Reserva;

public class Pendiente implements IEstadoReserva {
    public void pagar(Reserva reserva, Double monto) {
        reserva.getViaje().pagar();
        Abonado nuevoEstado = new Abonado();
        reserva.cambiarEstado(nuevoEstado);
    }

    public void cancelar(Reserva reserva) {
        Cancelado nuevoEstado = new Cancelado();
        reserva.cambiarEstado(nuevoEstado);
    }
}
