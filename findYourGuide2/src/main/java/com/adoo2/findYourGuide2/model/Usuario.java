package com.adoo2.findYourGuide2.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adoo2.findYourGuide2.rest.dto.UsuarioTuristaDTO;
import com.adoo2.findYourGuide2.service.MedioRegistro;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

    @OneToMany(mappedBy = "turista")
    private List<Viaje> historialViajes;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Trofeo> trofeos;
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
    public List<Trofeo> getListaTrofeos(){
        return trofeos;
    }

    public Long getId(){
        return id;
    }
}
