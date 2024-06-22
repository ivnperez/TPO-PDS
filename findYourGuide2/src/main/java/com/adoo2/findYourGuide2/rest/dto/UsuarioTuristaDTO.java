package com.adoo2.findYourGuide2.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioTuristaDTO {
    private String nombre;
    private String apellido;
    private int dni;
    private String email;
    private int telefono;
}