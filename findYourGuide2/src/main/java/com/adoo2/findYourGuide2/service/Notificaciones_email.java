package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Usuario;
import com.adoo2.findYourGuide2.model.Guia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Notificaciones_email implements INotificacion {

    @Autowired
    private IAdapterMail adapterMail;

    @Override
    public void enviarNotificacion(Usuario usuario) {
        adapterMail.enviarNotificacion(usuario);
    }

    @Override
    public void enviarNotificacion(Turista turista) {
        adapterMail.enviarNotificacion(turista);
    }

    @Override
    public void enviarCalificacion(Turista turista, Guia guia) {
        adapterMail.enviarCalificacion(turista, guia);
    }
}
