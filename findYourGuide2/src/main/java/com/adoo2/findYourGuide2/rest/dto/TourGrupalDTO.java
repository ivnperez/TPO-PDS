package com.adoo2.findYourGuide2.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourGrupalDTO {
    private String descripcion;
    private double precio;
    private int duracion;
    private String zona;
    private int tamMaxGrupo;
}
