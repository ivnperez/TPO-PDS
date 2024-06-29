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

    @Transient
    private Servicio tipo;

    public void agregarServicio(Guia guia, Servicios_Ofrecidos servOfrecido) {
        guia.getServOfrecidos().add(servOfrecido);
    }

    public void eliminarServicio(Guia guia, Servicios_Ofrecidos servAEliminar) {
        guia.getServOfrecidos().remove(servAEliminar);
    }

    public double precio() {
        return tipo.getPrecio();
    }
}
