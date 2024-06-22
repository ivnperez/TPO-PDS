package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Viaje;

public interface IEstadoViaje {
    void aceptar(Guia guia, Turista turista, Viaje viaje);
    void cancelar(Guia guia, Turista turista, Viaje viaje);
    void concretar(Guia guia, Turista turista, Viaje viaje);
    void reservar(Guia guia, Turista turista, Viaje viaje);
}

