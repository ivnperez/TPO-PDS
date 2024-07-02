package com.adoo2.findYourGuide2.model;
import java.util.Date;
import java.util.List;

import com.adoo2.findYourGuide2.service.CalificacionService;

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
    public boolean verificarCriterios(Guia guia, Turista turista,CalificacionService calificacionService) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("llegue a trofeo exito");
        List<Calificacion> listaCalif = calificacionService.buscarCalifcacionPorGuia(guia.getId()) ;
        int cant = listaCalif.size();
        System.out.println(cant);
        System.out.println(cant >= minimoCalificaciones);
        
        boolean darTrofeo = false;
        for (Calificacion calif : listaCalif) {
            if (calif.getPuntaje() >= calificacion && cant >= minimoCalificaciones) {
                darTrofeo = true;
            }
        }
        System.out.println(darTrofeo);
        return darTrofeo;
    }

    @Override
    public Trofeo otorgarTrofeo(Usuario usuario) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("llegue a otorgar trofeo exito");
        TrofeoExito trofeo = new TrofeoExito();
        usuario.getListaTrofeos().add(trofeo);
        trofeo.setUsuario(usuario);
        trofeo.setfecha(new Date());
        return trofeo;
    }
}
