package com.adoo2.findYourGuide2.rest;

import com.adoo2.findYourGuide2.model.Credencial;
import com.adoo2.findYourGuide2.service.IAdapterVerificadorCredencial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credenciales")
public class ControllerCredencial {

    @Autowired
    private IAdapterVerificadorCredencial adapter;

    @PostMapping("/verificar")
    public boolean verificarCredencial(@RequestBody Credencial credencial) {
        return adapter.verificarCredencial(credencial);
    }

    @PostMapping("/agregar")
    public void agregarCredencial(@RequestBody Credencial credencial) {
        // Lógica para agregar una credencial
    }

    @DeleteMapping("/eliminar")
    public void eliminarCredencial(@RequestBody Credencial credencial) {
        // Lógica para eliminar una credencial
    }
}
