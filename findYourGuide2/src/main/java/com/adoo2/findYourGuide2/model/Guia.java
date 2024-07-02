package com.adoo2.findYourGuide2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy = "guia")
    @JsonManagedReference
    private List<Calificacion> calificaciones;

    // Métodos de negocio
    // Se implementan en el servicio
    public List<Calificacion>getListaCalificaciones(){
        return calificaciones;
    }
}
