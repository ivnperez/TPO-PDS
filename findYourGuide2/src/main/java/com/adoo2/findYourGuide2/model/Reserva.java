package com.adoo2.findYourGuide2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaHora;
    private String estado;

    @ManyToOne
    private Turista turista;

    @ManyToOne
    private Guia guia;

    // Getters y Setters (Lombok se encarga de esto)
}
