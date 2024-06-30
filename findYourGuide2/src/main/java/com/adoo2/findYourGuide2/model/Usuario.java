package com.adoo2.findYourGuide2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adoo2.findYourGuide2.rest.dto.UsuarioTuristaDTO;
import com.adoo2.findYourGuide2.service.MedioRegistro;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private int dni;
    private String email;
    private int telefono;

    @Lob
    private byte[] fotoPerfil; // Assuming img is stored as a byte array

    @Autowired
    @Transient
    private MedioRegistro medio;

    public void agregarUsuario(Usuario usuario) {
        // Lógica para agregar un usuario
    }

    public void eliminarUsuario(Usuario usuario) {
        // Lógica para eliminar un usuario
    }

    public void login(UsuarioTuristaDTO usuarioDTO) {
        // Lógica para login
    }
}
