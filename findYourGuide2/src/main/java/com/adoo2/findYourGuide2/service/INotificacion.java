package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Usuario;
import com.adoo2.findYourGuide2.model.Guia;

public interface INotificacion {
    void enviarNotificacion(Usuario usuario);
    void enviarNotificacion(Turista turista);
    void enviarCalificacion(Turista turista, Guia guia);
}
