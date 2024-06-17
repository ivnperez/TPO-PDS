package com.adoo2.findYourGuide2.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NotificacionPush extends Notificacion {
    private String dispositivo;

    @Override
    public void enviar() {
        // Lógica para enviar notificación push
    }

    // Lombok se encargará de generar los getters, setters y los constructores
}
