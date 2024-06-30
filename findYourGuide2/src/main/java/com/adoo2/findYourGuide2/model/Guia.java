package com.adoo2.findYourGuide2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Guia extends Usuario {

    @ElementCollection
    private List<String> ciudadesServicio;

    @OneToMany
    private List<Servicios_Ofrecidos> servOfrecidos;

    @OneToOne
    @JoinColumn(name = "credencial_id", nullable = true)
    private Credencial credencial;

    @OneToMany(mappedBy = "guia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Calificacion> calificaciones;

    @OneToMany(mappedBy = "guia")
    private List<Viaje> historialViajes;

    // Métodos de negocio
    // Se implementan en el servicio
}
