package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.rest.dto.UsuarioGuiaDTO;
import com.adoo2.findYourGuide2.rest.dto.UsuarioTuristaDTO;

public interface MedioRegistro {
    void agregarTurista(UsuarioTuristaDTO usuarioDTO);
    void agregarGuia(UsuarioGuiaDTO usuarioDTO);
    void login(UsuarioTuristaDTO usuarioDTO);
}
