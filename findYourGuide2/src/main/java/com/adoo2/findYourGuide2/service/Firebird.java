package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Guia;
import org.springframework.stereotype.Service;

@Service
public class Firebird implements IAdapterPush {

    @Override
    public void enviarNotificacion(Turista turista) {
        // Lógica para enviar una notificación usando Firebird
        System.out.println("Enviando notificación con Firebird a: " + turista.getEmail());
    }

    @Override
    public void enviarCalificacion(Turista turista, Guia guia) {
        // Lógica para enviar una calificación usando Firebird
        System.out.println("Enviando calificación con Firebird a: " + turista.getEmail() + " sobre el guía: " + guia.getEmail());
    }
}
