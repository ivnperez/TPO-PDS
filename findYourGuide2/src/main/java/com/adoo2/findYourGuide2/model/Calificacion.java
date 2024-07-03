package com.adoo2.findYourGuide2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.adoo2.findYourGuide2.service.CalificacionService;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "guia_id", nullable = false)
    @JsonBackReference
    private Guia guia;

    @ManyToOne
    @JoinColumn(name = "turista_id", nullable = false)
    private Turista turista;

    private int puntaje;
    private String comentario;
    private Date fecha;
    @Transient
    private static List<Trofeo> interesados = new ArrayList<>();


    public static CalificacionTrofeo generarCalificacion(Guia guia, Turista turista, int puntaje, String comentario,CalificacionService calificacionService) {
        System.out.println("llegue a calificacion");
        Calificacion calificacion = new Calificacion();
        calificacion.guia= guia;
        calificacion.turista= turista;
        calificacion.fecha =(new Date());
        calificacion.puntaje =puntaje;
        calificacion.comentario = comentario;
        //interesados.forEach(trofeo -> trofeo.verificarCriterios(guia, turista));
        CalificacionTrofeo ct= new CalificacionTrofeo();
        ct.setTrofeo(null);
        for (Trofeo observador : interesados) {
            if (observador.verificarCriterios(guia, turista,calificacionService)) {
                Trofeo otorgado = observador.otorgarTrofeo(guia);
                ct.setTrofeo(otorgado);
            }
        }
        ct.setCalificacion(calificacion);
        return ct;
    }

    public static void agregarObservador(Trofeo observador) {
        interesados.add(observador);}

    public static List<Trofeo>  devolverObservadores() {
        for (Object interesados : interesados) {
            System.out.print(interesados);
        }
        return interesados;
    }

    public void eliminarObservador(Trofeo observador) {
        this.interesados.remove(observador);
    }
    public int getPuntaje(){
        return puntaje;
    }
    public void setGuia(Guia guia){
        this.guia = guia;
    }
    public Long getGuia(){
        return id;
    }
}

