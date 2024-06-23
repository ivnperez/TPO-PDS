package com.adoo2.findYourGuide2.rest;

import com.adoo2.findYourGuide2.model.Chat;
import com.adoo2.findYourGuide2.model.Mensaje;
import com.adoo2.findYourGuide2.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/enviarMensaje")
    public void enviarMensaje(@RequestBody Mensaje mensaje) {
        chatService.enviarMensaje(mensaje);
    }

    @PostMapping("/crearChat")
    public Chat crearChat(@RequestBody Chat chat) {
        return chatService.crearChat(chat);
    }
}
