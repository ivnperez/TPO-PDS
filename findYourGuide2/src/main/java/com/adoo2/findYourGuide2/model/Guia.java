package com.adoo2.findYourGuide2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Guia extends Usuario {
    private String licencia;
    private String idiomas;
    private String descripcion;
    private Double calificacionPromedio;

    @OneToMany(mappedBy = "guia")
    private List<Reserva> reservas;

    // Lombok se encarga de generar los getters, setters y los constructores
}
