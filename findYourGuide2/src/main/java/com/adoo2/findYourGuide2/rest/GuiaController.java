package com.adoo2.findYourGuide2.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adoo2.findYourGuide2.model.Calificacion;
import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.service.GuiaService;

@RestController
@RequestMapping("/guias")
public class GuiaController {

    @Autowired
    private GuiaService guiaService;

    @GetMapping
    public List<Guia> obtenerGuias() {
        return guiaService.obtenerGuia(null);
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
