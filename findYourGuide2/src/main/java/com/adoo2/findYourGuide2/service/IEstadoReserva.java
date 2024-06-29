package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Reserva;

public interface IEstadoReserva {
    void pagar(Reserva reserva, Double monto);

    void cancelar(Reserva reserva);
}
