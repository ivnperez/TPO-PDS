package com.adoo2.findYourGuide2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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
    private Guia guia;

    @ManyToOne
    @JoinColumn(name = "turista_id", nullable = false)
    private Turista turista;

    private int puntaje;
    private String comentario;
    private Date fecha;

    @OneToMany
    @JoinColumn(name = "trofeo_id")
    static private List<Trofeo> interesados;

    public static Calificacion generarCalificacion(Guia guia, Turista turista, int puntaje) {
        Calificacion calificacion = new Calificacion();
        calificacion.setGuia(guia);
        calificacion.setTurista(turista);
        calificacion.setFecha(new Date());
        calificacion.setPuntaje(puntaje);
        interesados.forEach(trofeo -> trofeo.verificarCriterios(guia, turista));
        return calificacion;
    }

    public void agregarObservador(Trofeo observador) {
        this.interesados.add(observador);
    }

    public void eliminarObservador(Trofeo observador) {
        this.interesados.remove(observador);
    }
}
