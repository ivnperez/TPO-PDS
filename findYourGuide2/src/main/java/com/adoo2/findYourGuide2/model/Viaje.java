package com.adoo2.findYourGuide2.model;

import com.adoo2.findYourGuide2.service.IEstadoViaje;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    private double comisionDePlataforma;
    private double anticipo;
    private double total;

    @ManyToOne
    @JoinColumn(name = "guia_id", nullable = false)
    private Guia guia;

    @ManyToOne
    @JoinColumn(name = "turista_id", nullable = false)
    private Turista turista;

    @ManyToOne
    @JoinColumn(name = "servicios_ofrecidos_id", nullable = false)
    private Servicios_Ofrecidos tour;

    @ManyToOne
    @JoinColumn(name = "factura_id", nullable = false)
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;

    @Transient
    private IEstadoViaje estadoViaje;

    public double precioTotal() {
        // Lógica para calcular el precio total
        return total + tour.precio(); // Asumiendo que `tour.precio()` retorna el precio del servicio ofrecido
    }

    public void aceptar(Guia guia, Turista turista) {
        estadoViaje.aceptar(guia, turista, this);
    }

    public void cancelar(Guia guia, Turista turista) {
        estadoViaje.cancelar(guia, turista, this);
    }

    public void concretar(Guia guia, Turista turista) {
        estadoViaje.concretar(guia, turista, this);
    }

    public void reservar(Guia guia, Turista turista) {
        estadoViaje.reservar(guia, turista, this);
    }

    public void pagar() {
        // Lógica para pagar el viaje
    }
}
