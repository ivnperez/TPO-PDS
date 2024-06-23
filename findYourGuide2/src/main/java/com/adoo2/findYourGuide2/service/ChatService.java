package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Chat;
import com.adoo2.findYourGuide2.model.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private IAdapterChat adapterChat;

    public void enviarMensaje(Mensaje mensaje) {
        adapterChat.enviarMensaje(mensaje);
    }

    public Chat crearChat(Chat chat) {
        // Lógica para crear y guardar un chat
        return chat;
    }
}
