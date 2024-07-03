package com.adoo2.findYourGuide2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adoo2.findYourGuide2.rest.dto.CrearViajeRequest;
import com.adoo2.findYourGuide2.model.Viaje;
import com.adoo2.findYourGuide2.service.ViajeService;

@RestController
@RequestMapping("/viajes")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @PostMapping
    public ResponseEntity<Viaje> crearViaje(@RequestBody CrearViajeRequest request) {
        try {
            Viaje nuevoViaje = viajeService.crearViaje(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoViaje);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}/aceptar")
    public ResponseEntity<Viaje> aceptar(@PathVariable Long id) {
        try {
            Viaje viaje = viajeService.aceptarViaje(id);
            return ResponseEntity.ok(viaje);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}/concretar")
    public ResponseEntity<Viaje> concretar(@PathVariable Long id) {
        try {
            Viaje viaje = viajeService.concretarViaje(id);
            return ResponseEntity.ok(viaje);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}/reservar")
    public ResponseEntity<Viaje> reservar(@PathVariable Long id) {
        try {
            Viaje viaje = viajeService.reservarViaje(id);
            return ResponseEntity.ok(viaje);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PostMapping("/{id}/abonar-reserva")
    public ResponseEntity<Viaje> abonarReserva(@PathVariable Long id) {
        try {
            Viaje viaje = viajeService.abonarReserva(id);
            return ResponseEntity.ok(viaje);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/{id}/abonar-total")
    public ResponseEntity<Viaje> abonarTotal(@PathVariable Long id) {
        try {
            Viaje viaje = viajeService.abonarTotal(id);
            return ResponseEntity.ok(viaje);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
