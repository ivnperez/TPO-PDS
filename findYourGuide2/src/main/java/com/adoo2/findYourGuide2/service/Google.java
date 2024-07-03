package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.rest.dto.UsuarioTuristaDTO;
import com.adoo2.findYourGuide2.rest.dto.UsuarioGuiaDTO;

public class Google implements MedioRegistro {

    @Override
    public void agregarTurista(UsuarioTuristaDTO usuarioDTO) {
        System.out.println("Turista registrado con Google");
    }

    @Override
    public void agregarGuia(UsuarioGuiaDTO usuarioDTO) {
        System.out.println("Guía registrado con Google");
    }

    @Override
    public void login(UsuarioTuristaDTO usuarioDTO) {
        System.out.println("Turista logueado con Google");
    }
}

