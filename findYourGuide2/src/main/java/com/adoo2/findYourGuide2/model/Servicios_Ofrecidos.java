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
public class Servicios_Ofrecidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String zona;
    
    @ElementCollection
    private List<String> idiomas;

    private int tamMaxGrupo;

    @Enumerated(EnumType.STRING)
    private Servicio tipo;

    public void agregarServicio(Servicios_Ofrecidos servOfrecido) {
        // Lógica para agregar un servicio ofrecido
    }

    public void eliminarServicio(Servicios_Ofrecidos servAEliminar) {
        // Lógica para eliminar un servicio ofrecido
    }

    public double precio() {
        // Lógica para calcular el precio del servicio ofrecido
        return 0.0;
    }
}
