package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Mensaje;
import org.springframework.stereotype.Service;

@Service
public class SendBird implements IAdapterChat {

    @Override
    public void enviarMensaje(Mensaje mensaje) {
        // Implementación específica para enviar un mensaje usando SendBird
        System.out.println("Enviando mensaje con SendBird: " + mensaje.getMensaje());
    }
}
