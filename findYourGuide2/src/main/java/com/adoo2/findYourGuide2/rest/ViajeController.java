package com.adoo2.findYourGuide2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Viaje;
import com.adoo2.findYourGuide2.repository.ViajeRepository;

@RestController
@RequestMapping("/viajes")
public class ViajeController {

    @Autowired
    private ViajeRepository viajeRepository;

    @PutMapping("/{id}/aceptar")
    public ResponseEntity<Viaje> aceptar(@PathVariable Long id) {
        try {
            Viaje viaje = viajeRepository.findById(id)
                .orElseThrow(() -> new Exception("Viaje no encontrado"));
            Guia guia = viaje.getGuia();
            Turista turista = viaje.getTurista();
            Viaje viajeActualizado = viaje.aceptar(guia, turista);
            return ResponseEntity.ok(viajeActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}/concretar")
    public ResponseEntity<Viaje> concretar(@PathVariable Long id) {
        try {
            Viaje viaje = viajeRepository.findById(id)
                .orElseThrow(() -> new Exception("Viaje no encontrado"));
            Guia guia = viaje.getGuia();
            Turista turista = viaje.getTurista();
            Viaje viajeActualizado = viaje.concretar(guia, turista);
            return ResponseEntity.ok(viajeActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
