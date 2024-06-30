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
@DiscriminatorValue("RESEÑA")
public class TrofeoReseña extends Trofeo {
    private int minPuntuacionesDadas = 11;

    @Override
    public boolean verificarCriterios() {
        // Lógica para verificar criterios de TrofeoReseña
        return true;
    }

    @Override
    public void otorgarTrofeo(Turista turista, Trofeo trofeo) {
        // Lógica específica para otorgar TrofeoReseña
    }
}
