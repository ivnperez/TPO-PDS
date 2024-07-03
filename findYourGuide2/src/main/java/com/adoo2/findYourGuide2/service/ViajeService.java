package com.adoo2.findYourGuide2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adoo2.findYourGuide2.rest.dto.CrearViajeRequest;
import com.adoo2.findYourGuide2.model.*;
import com.adoo2.findYourGuide2.repository.*;

@Service
public class ViajeService {

        @Autowired
        private ViajeRepository viajeRepository;

        @Autowired
        private GuiaRepository guiaRepository;

        @Autowired
        private TuristaRepository turistaRepository;

        @Autowired
        private Servicios_OfrecidosRepository serviciosOfrecidosRepository;

        @Autowired
        private FacturaRepository facturaRepository;

        @Transactional
        public Viaje crearViaje(CrearViajeRequest request) {
                System.out.println("CREANDO VIAJE");
                Guia guia = guiaRepository.findById(request.getGuiaId())
                                .orElseThrow(() -> new IllegalArgumentException("Guia no encontrado"));
                System.out.println("GUIA");
                System.out.println(guia.getApellido());
                Turista turista = turistaRepository.findById(request.getTuristaId())
                                .orElseThrow(() -> new IllegalArgumentException("Turista no encontrado"));
                System.out.println("TURISTA");
                System.out.println(turista.getApellido());
                // Servicios_Ofrecidos tour =
                // serviciosOfrecidosRepository.findById(request.getTourId())
                // .orElseThrow(() -> new IllegalArgumentException("Servicio no encontrado"));
                // Factura factura = facturaRepository.findById(request.getFacturaId())
                // .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada"));

                Viaje viaje = new Viaje();
                viaje.setFechaInicio(request.getFechaInicio());
                viaje.setFechaFin(request.getFechaFin());
                viaje.setComisionDePlataforma(request.getComisionDePlataforma());
                viaje.setAnticipo(request.getAnticipo());
                viaje.setTotal(request.getTotal());
                viaje.setGuia(guia);
                viaje.setTurista(turista);
                // viaje.setTour(tour);
                // viaje.setFactura(factura);
                viaje.setEstadoViaje(new Disponible()); // Establecer el estado inicial
                viaje.setEstado("Disponible");

                return viajeRepository.save(viaje);
        }

        @Transactional
        public Viaje aceptarViaje(Long id) {
                Viaje viaje = viajeRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("Viaje no encontrado"));
                System.out.println("VIAJE");
                System.out.println(viaje.getId());

                Guia guia = viaje.getGuia();
                Turista turista = viaje.getTurista();
                viaje.setEstadoViaje(getEstadoViaje(viaje.getEstado()));
                viaje.aceptar(guia, turista);
                return viajeRepository.save(viaje);
        }

        @Transactional
        public Viaje concretarViaje(Long id) {
                Viaje viaje = viajeRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("Viaje no encontrado"));
                Guia guia = viaje.getGuia();
                Turista turista = viaje.getTurista();
                viaje.setEstadoViaje(getEstadoViaje(viaje.getEstado()));
                viaje.concretar(guia, turista);
                return viajeRepository.save(viaje);
        }

        @Transactional
        public Viaje reservarViaje(Long id) {
                Viaje viaje = viajeRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("Viaje no encontrado"));
                Guia guia = viaje.getGuia();
                Turista turista = viaje.getTurista();
                viaje.setEstadoViaje(getEstadoViaje(viaje.getEstado()));
                viaje.reservar(guia, turista);
                return viajeRepository.save(viaje);
        }

        public IEstadoViaje getEstadoViaje(String estado) {
                switch (estado) {
                        case "Aceptado":
                                return new Aceptado();
                        case "Reservado":
                                return new Reservado();
                        case "Concretado":
                                return new Concretado();
                        default:
                                return new Disponible();
                }
        }
}
