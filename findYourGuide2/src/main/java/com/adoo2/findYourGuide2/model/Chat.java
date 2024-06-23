package com.adoo2.findYourGuide2.model;

import com.adoo2.findYourGuide2.service.IAdapterChat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "turista_id", nullable = false)
    private Turista turista;

    @ManyToOne
    @JoinColumn(name = "guia_id", nullable = false)
    private Guia guia;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    private String canal;

    @Transient
    @Autowired
    private IAdapterChat adapter;

    public void enviarMensaje(Mensaje mensaje) {
        adapter.enviarMensaje(mensaje);
    }
}
