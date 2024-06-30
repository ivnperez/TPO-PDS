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
public class Turista extends Usuario {
    @ElementCollection
    private List<String> destinosFav;

    private int puntuacion;
    @OneToMany(mappedBy = "turista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Calificacion> calificaciones;

    @Override
    public void agregarUsuario(Usuario usuario) {
        // Lógica específica para agregar un usuario turista
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        // Lógica específica para eliminar un usuario turista
    }
}
