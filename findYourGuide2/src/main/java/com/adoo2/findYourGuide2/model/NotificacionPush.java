package com.adoo2.findYourGuide2.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NotificacionPush extends Notificacion {
    private String dispositivo;

    @Override
    public void enviar() {
        // Lógica para enviar notificación push
    }

    // Getters y Setters
    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }
}
