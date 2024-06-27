package com.adoo2.findYourGuide2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

import com.adoo2.findYourGuide2.service.IEstadoReserva;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaHora;
    private IEstadoReserva estado;

    @ManyToOne
    private Turista turista;

    @ManyToOne
    private Guia guia;

    @OneToOne
    private Viaje viaje;

    public void pagar() {
        estado.pagar(this, null);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public void cambiarEstado(IEstadoReserva nuevoEstado) {
        this.setEstado(nuevoEstado);
    }

}
