package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Reserva;

public class Cancelado implements IEstadoReserva {
    public void pagar(Reserva reserva, Double monto) {
        System.out.println("No se puede pagar la reserva dado que está cancelada");
    }

    public void cancelar(Reserva reserva) {
        System.out.println("La reserva ya está cancelada");
    }
}
