package com.adoo2.findYourGuide2.rest.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CrearViajeRequest {
    private Date fechaInicio;
    private Date fechaFin;
    private double comisionDePlataforma;
    private double anticipo;
    private double total;
    private Long guiaId;
    private Long turistaId;
    private Long tourId;
    private Long facturaId;
}
