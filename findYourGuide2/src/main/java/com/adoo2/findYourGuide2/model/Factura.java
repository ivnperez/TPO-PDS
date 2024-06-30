package com.adoo2.findYourGuide2.model;

import com.adoo2.findYourGuide2.service.IEstado;
import com.adoo2.findYourGuide2.service.Notificaciones_email;

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
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double comisionDePlataforma;
    private double montoTotal;

    @Temporal(TemporalType.DATE)
    private Date fechaFactura;

    @ManyToOne
    @JoinColumn(name = "viaje_id", nullable = false)
    private Viaje viaje;

    @ManyToOne
    @JoinColumn(name = "servicio_ofrecido_id", nullable = false)
    private Servicios_Ofrecidos servicio;

    @Transient
    private IEstado estado;

//    @Autowired
    private Notificador notificador;

    public void enviarFactura(Turista turista) { 
        String mensaje = String.format("Estimado %s %s,\n\nAdjunto a este correo encontrará la factura del viaje.\n\nMonto total: %.2f\nComisión de plataforma: %.2f\nFecha: %s\n\nGracias por usar nuestros servicios.",
                turista.getNombre(), turista.getApellido(), precioTotal(), comisionDePlataforma, fechaFactura.toString());

        notificador.setGuia(this.viaje.getGuia());
        notificador.setTurista(turista);
        notificador.setMensaje(mensaje);
        notificador.cambiarTipoNotificacion(new Notificaciones_email());

        notificador.enviarNotificacion(turista);
    }


    public double precioTotal() {
        return montoTotal + comisionDePlataforma;
    }

    public void cambiarEstado(IEstado nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void pagar() {
        estado.pagar(this);
    }
}
