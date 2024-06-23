package com.adoo2.findYourGuide2.model;

import com.adoo2.findYourGuide2.service.INotificacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notificador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "guia_id", nullable = false)
    private Guia guia;

    @ManyToOne
    @JoinColumn(name = "turista_id", nullable = false)
    private Turista turista;

    private String mensaje;

    @Transient
    @Autowired
    private INotificacion tipo;

    public void enviarNotificacion(Usuario usuario) {
        tipo.enviarNotificacion(usuario);
    }

    public void enviarNotificacion(Turista turista) {
        tipo.enviarNotificacion(turista);
    }

    public void enviarCalificacion(Turista turista, Guia guia) {
        tipo.enviarCalificacion(turista, guia);
    }

    public void cambiarTipoNotificacion(INotificacion nuevoTipo) {
        this.tipo = nuevoTipo;
    }
}
