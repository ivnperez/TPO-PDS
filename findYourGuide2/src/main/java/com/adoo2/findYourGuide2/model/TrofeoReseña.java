package com.adoo2.findYourGuide2.model;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.adoo2.findYourGuide2.service.CalificacionService;

import java.util.stream.Collectors;

import com.adoo2.findYourGuide2.service.UsuarioService;

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
    public boolean verificarCriterios(Guia guia, Turista turista,CalificacionService calificacionService) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("llegue a trofeo reseña");
        boolean darTrofeo = false;
        List<Calificacion> listaCalif = calificacionService.buscarCalifcacionPorTuristaYGuia(turista.getId(),guia.getId()) ;
        for(Calificacion calificacion:listaCalif){
            System.out.println(calificacion.toString());
        }
        List<Calificacion> CalificacionesUnicas = listaCalif.stream()
        .collect(Collectors.groupingBy(Calificacion::getGuia))
        .values()
        .stream()
        .map(calificaciones -> calificaciones.get(0)) // Obtener la primera calificación por cada guía
        .collect(Collectors.toList());

        if (turista.getListaTrofeos().size() > 1) {
            return darTrofeo;
        }

        if (CalificacionesUnicas.size()>= minPuntuacionesDadas) {
            darTrofeo = true;
        }

        return darTrofeo;
    }
    @Override
    public Trofeo otorgarTrofeo(Usuario usuario) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("llegue a otorgar trofeo reseña");
        TrofeoReseña trofeo = new TrofeoReseña();
        usuario.getListaTrofeos().add(trofeo);
        trofeo.setUsuario(usuario);
        trofeo.setfecha(new Date());
        return trofeo;
    }
}
