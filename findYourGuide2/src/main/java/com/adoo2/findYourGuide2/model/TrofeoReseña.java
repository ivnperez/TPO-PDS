package com.adoo2.findYourGuide2.model;

import java.util.stream.Collectors;

import com.adoo2.findYourGuide2.service.UsuarioService;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("RESEÑA")
public class TrofeoReseña extends Trofeo {
    private int minPuntuacionesDadas = 11;

    @Override
    public boolean verificarCriterios(Guia guia, Turista turista) {

        List<Calificacion> CalificacionesUnicas = guia.getCalificaciones().stream()
                .distinct()
                .collect(Collectors.toList());
        // if (CalificacionesUnicas.size()>= minPuntuacionesDadas) {
        // otorgarTrofeo(guia);
        // }

        return CalificacionesUnicas.size() >= minPuntuacionesDadas;
    }

    @Override
    public void otorgarTrofeo(Turista turista, Trofeo trofeo) {
        // Lógica específica para otorgar TrofeoReseña
        // TrofeoReseña trofeo = new TrofeoReseña();
        // usuario.getListaTrofeos().add(trofeo);
        // trofeo.setUsuario(usuario);
    }
}
