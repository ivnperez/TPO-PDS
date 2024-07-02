package com.adoo2.findYourGuide2.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalificacionRequest {
    public Long guiaId;
    public Long turistaId;
    public int puntaje;
    public String comentario;

    // getters y setters
}