package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Usuario;
import com.adoo2.findYourGuide2.model.Guia;
import org.springframework.stereotype.Service;

@Service
public class JavaMail implements IAdapterMail {

    @Override
    public void enviarNotificacion(Usuario usuario) {
        // Lógica para enviar una notificación usando JavaMail
        System.out.println("Enviando notificación con JavaMail a: " + usuario.getEmail());
    }

    @Override
    public void enviarCalificacion(Turista turista, Guia guia) {
        // Lógica para enviar una calificación usando JavaMail
        System.out.println("Enviando calificación con JavaMail a: " + turista.getEmail() + " sobre el guía: " + guia.getEmail());
    }
}
