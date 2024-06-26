package com.adoo2.findYourGuide2.rest;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Usuario;
import com.adoo2.findYourGuide2.service.GuiaService;
import com.adoo2.findYourGuide2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private GuiaService guiaService;
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
    @PostMapping("/guia")
    public Usuario createUsuario(@RequestBody Guia guia) {
        return guiaService.save(guia);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}

