package com.adoo2.findYourGuide2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_trofeo", discriminatorType = DiscriminatorType.STRING)
public abstract class Trofeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "turista_id", nullable = false)
    private Turista turista;

    @Temporal(TemporalType.DATE)
    private Date fechaObtencion;

    @ManyToOne
    @JoinColumn(name = "calificacion_id", nullable = false)
    private Calificacion observable;

    public abstract boolean verificarCriterios();
    
    public void otorgarTrofeo(Turista turista, Trofeo trofeo) {
        // Lógica para otorgar el trofeo
    }
}
