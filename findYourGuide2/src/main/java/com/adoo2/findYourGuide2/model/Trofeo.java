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
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Temporal(TemporalType.DATE)
    private Date fechaObtencion;

    @ManyToOne
    @JoinColumn(name = "calificacion_id", nullable = false)
    private Calificacion observable;

    public abstract boolean verificarCriterios(Guia guia, Turista turista);

    public abstract void otorgarTrofeo(Usuario usuario);

}
