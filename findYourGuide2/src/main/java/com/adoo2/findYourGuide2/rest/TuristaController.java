package com.adoo2.findYourGuide2.rest;

import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.service.TuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turista")
public class TuristaController {

    @Autowired
    private TuristaService turistaService;

    @GetMapping
    public List<Turista> obtenerTuristas() {
        return turistaService.obtenerTurista(null);
    }

    @PostMapping
    public Turista createUsuario(@RequestBody Turista turista) {
        return turistaService.save(turista);
    }
}
