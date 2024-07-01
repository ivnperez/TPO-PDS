package com.adoo2.findYourGuide2.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("EXITO")
public class TrofeoExito extends Trofeo {
    private double calificacion = 4.5;
    private int minimoCalificaciones = 10;

    @Override
    public boolean verificarCriterios(Guia guia, Turista turista) {
        int cant = guia.getCalificaciones().size();
        boolean darTrofeo = false;
        for (Calificacion calif : guia.getCalificaciones()) {
            if (calif.getPuntaje() > calificacion && cant > minimoCalificaciones) {
                darTrofeo = true;
            }
        }
        // if ((darTrofeo)) {
        // otorgarTrofeo(guia);
        // }
        return darTrofeo;
    }

    @Override
    public void otorgarTrofeo(Turista turista, Trofeo trofeo) {
        // Lógica específica para otorgar TrofeoExito
        // TrofeoExito trofeo = new TrofeoExito();
        // usuario.getListaTrofeos().add(trofeo);
        // trofeo.setUsuario(usuario);
    }
}
