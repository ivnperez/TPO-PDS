package com.adoo2.findYourGuide2.rest;

import com.adoo2.findYourGuide2.model.Calificacion;
import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.service.GuiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guias")
public class GuiaController {

    @Autowired
    private GuiaService guiaService;

    @GetMapping
    public List<Guia> obtenerGuias() {
        return guiaService.obtenerGuia(null);
    }

    @PostMapping
    public Guia createUsuario(@RequestBody Guia guia) {
        return guiaService.save(guia);
    }

    @PostMapping("/{guiaId}/calificaciones")
    public void agregarCalificacion(@PathVariable Long guiaId, @RequestBody Calificacion calificacion) {
        guiaService.agregarCalificacion(calificacion, guiaId);
    }

    @GetMapping("/buscar")
    public List<Guia> buscarGuia(@RequestParam String nombre, @RequestParam String apellido) {
        return guiaService.buscarGuia(nombre, apellido);
    }
}
