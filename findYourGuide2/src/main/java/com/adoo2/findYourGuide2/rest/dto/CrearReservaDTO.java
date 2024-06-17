package com.adoo2.findYourGuide2.rest.dto;

import java.time.LocalDateTime;

public class CrearReservaDTO {
    private Long turistaId;
    private Long guiaId;
    private LocalDateTime fechaHora;

    // Getters y Setters
    public Long getTuristaId() {
        return turistaId;
    }

    public void setTuristaId(Long turistaId) {
        this.turistaId = turistaId;
    }

    public Long getGuiaId() {
        return guiaId;
    }

    public void setGuiaId(Long guiaId) {
        this.guiaId = guiaId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}
