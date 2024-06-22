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
    public boolean verificarCriterios() {
        // Lógica para verificar criterios de TrofeoExito
        return true;
    }

    @Override
    public void otorgarTrofeo(Usuario usuario, Trofeo trofeo) {
        // Lógica específica para otorgar TrofeoExito
    }
}
