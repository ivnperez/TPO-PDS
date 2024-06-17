package com.adoo2.findYourGuide2.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turista extends Usuario {
    private int edad;
    private String nacionalidad;

    // Lombok se encargará de generar los getters, setters y los constructores
}