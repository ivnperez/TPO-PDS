package com.adoo2.findYourGuide2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.adoo2.findYourGuide2.rest.dto.UsuarioTuristaDTO;
import com.adoo2.findYourGuide2.service.MedioRegistro;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Usuario implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private int dni;
    private String email;
    private String pass;
    private int telefono;

    @Lob
    private byte[] fotoPerfil; // Assuming img is stored as a byte array

    @OneToMany(mappedBy = "turista")
    private List<Viaje> historialViajes;

    @Autowired
    @Transient
    private MedioRegistro medio;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trofeo> listaTrofeos;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Calificacion> listaCalificaciones;

    public void agregarUsuario(Usuario usuario) {
        // Lógica para agregar un usuario
    }

    public void eliminarUsuario(Usuario usuario) {
        // Lógica para eliminar un usuario
    }

    public void login(UsuarioTuristaDTO usuarioDTO) {
        // Lógica para login
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this instanceof Guia) {
            return List.of(new SimpleGrantedAuthority("GUIA"));
        } else if (this instanceof Turista) {
            return List.of(new SimpleGrantedAuthority("TURISTA"));
        } else {
            return List.of();
        }
    }
    @Override
    public String getPassword() {
        return this.pass;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
