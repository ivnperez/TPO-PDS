package com.adoo2.findYourGuide2.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.adoo2.findYourGuide2.auth.AuthenticationRequest;
import com.adoo2.findYourGuide2.auth.AuthenticationResponse;
import com.adoo2.findYourGuide2.auth.RegisterRequest;
import com.adoo2.findYourGuide2.config.JwtService;
import com.adoo2.findYourGuide2.model.Usuario;
import com.adoo2.findYourGuide2.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
        private final UsuarioRepository repository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest request) {
                var user = Usuario.builder()
                                .nombre(request.getNombre())
                                .telefono(request.getTelefono())
                                .email(request.getEmail())
                                .pass(passwordEncoder.encode(request.getPass()))
                                .build();

                repository.save(user);
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .accessToken(jwtToken)
                                .build();
        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));

                var user = repository.findByEmail(request.getEmail())
                                .orElseThrow();
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .accessToken(jwtToken)
                                .build();
        }
}

