package com.adoo2.findYourGuide2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    @Transient
    private IEstadoReserva estado;

    @ManyToOne
    private Turista turista;

    @ManyToOne
    private Guia guia;

    @OneToOne
    private Viaje viaje;

    public void pagar(Double monto) {
        estado.pagar(this, monto);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public void cambiarEstado(IEstadoReserva nuevoEstado) {
        this.setEstado(nuevoEstado);
    }

}
