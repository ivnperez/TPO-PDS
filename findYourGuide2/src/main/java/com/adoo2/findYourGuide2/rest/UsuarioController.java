package com.adoo2.findYourGuide2.rest;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoo2.findYourGuide2.model.Calificacion;
import com.adoo2.findYourGuide2.model.CalificacionTrofeo;
import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Trofeo;
import com.adoo2.findYourGuide2.model.TrofeoExito;
import com.adoo2.findYourGuide2.model.TrofeoReseña;
import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.model.Usuario;
import com.adoo2.findYourGuide2.rest.dto.CalificacionRequest;
import com.adoo2.findYourGuide2.service.CalificacionService;
import com.adoo2.findYourGuide2.service.GuiaService;
import com.adoo2.findYourGuide2.service.TrofeoService;
import com.adoo2.findYourGuide2.service.TuristaService;
import com.adoo2.findYourGuide2.service.UsuarioService;

import jakarta.persistence.Transient;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private GuiaService guiaService;

    @Autowired
    private TuristaService turistaService;
    @Autowired
    private CalificacionService calificacionService;
    @Autowired
    @Transient
    private TrofeoService trofeoService;
  
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }
    // @PostMapping("/guia")
    // public Usuario createUsuario(@RequestBody Guia guia) {
    //     return guiaService.save(guia);
    // }

    @PostMapping("/guia")
    public Usuario createGuia(@RequestBody Guia guia) {
        return guiaService.save(guia);
    }

    //codigo que se debe ejecutar al iniciar sistema
    @PostMapping("/agregarTrofeosObervadores")
    public boolean agregarTrofeosObervadores() {
        System.out.println("--------------------------------------------------------------------------------");
        TrofeoExito trofeoExito = new TrofeoExito();
        TrofeoReseña trofeoReseña = new TrofeoReseña();
        Calificacion.agregarObservador(trofeoExito);
        Calificacion.agregarObservador(trofeoReseña);
        
        return true; // Devuelve algo relevante o cambia la lógica según tu necesidad
    }
    @PostMapping("/validarObervadores")
    public  List<Trofeo> validarObervadores() {
        return Calificacion.devolverObservadores(); // Devuelve algo relevante o cambia la lógica según tu necesidad
    }

    @PostMapping("/generarCalificacion")
    public  CalificacionTrofeo generarCalificacion(@RequestBody CalificacionRequest request) {
        System.out.println("--------------------------------------------------------------------------------");
        Long guiaId = request.guiaId;
        Long turistaId = request.turistaId;
        int puntaje = request.puntaje;
        String comentario = request.comentario;
        Guia guia = guiaService.findById(guiaId).get();
        Turista turista = turistaService.buscarTurista(turistaId);
        CalificacionTrofeo ct = Calificacion.generarCalificacion(guia, turista, puntaje, comentario,calificacionService);
        List<Trofeo> listaTrofeo = ct.getTrofeo();
        for (Trofeo trofeo : listaTrofeo) {
            if(trofeo!=null){
                trofeoService.save(trofeo);
            }
        }
        calificacionService.save(ct.getCalificacion());
        return ct;
        // Devuelve algo relevante o cambia la lógica según tu necesidad
    }

    @GetMapping("/CalificacionesTurista/{id}")
    public List<Calificacion>getCalificacionByTuristaId(@PathVariable Long id) {
        return calificacionService.buscarCalifcacionPorTurista(id);
    }
    @GetMapping("/CalificacionesGuia/{id}")
    public List<Calificacion> getCalificacionByGuiaId(@PathVariable Long id) {
        return calificacionService.buscarCalifcacionPorGuia(id);
    }


    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}

