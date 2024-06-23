package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Usuario;
import com.adoo2.findYourGuide2.model.Guia;
import org.springframework.stereotype.Service;

@Service
public class Notificaciones_push implements INotificacion {

    @Override
    public void enviarNotificacion(Usuario usuario) {
        // Lógica para enviar una notificación push a un usuario
        System.out.println("Enviando notificación push a: " + usuario.getEmail());
    }

    @Override
    public void enviarNotificacion(Turista turista) {
        // Lógica para enviar una notificación push a un turista
        System.out.println("Enviando notificación push a: " + turista.getEmail());
    }

    @Override
    public void enviarCalificacion(Turista turista, Guia guia) {
        // Lógica para enviar una calificación por notificación push
        System.out.println("Enviando calificación por notificación push a: " + turista.getEmail() + " sobre el guía: " + guia.getEmail());
    }
}
