package com.adoo2.findYourGuide2.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.adoo2.findYourGuide2.auth.AuthenticationRequest;
import com.adoo2.findYourGuide2.auth.AuthenticationResponse;
import com.adoo2.findYourGuide2.auth.RegisterRequest;
import com.adoo2.findYourGuide2.config.JwtService;
import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.repository.GuiaRepository;
import com.adoo2.findYourGuide2.repository.TuristaRepository;
import com.adoo2.findYourGuide2.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
        private final UsuarioRepository repository;
        private final TuristaRepository turistaRepository;
        private final GuiaRepository guiaRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest request) {
                if (request.getRole().equals("turista")) {
                        var user = new Turista(
                                        request.getNombre(),
                                        request.getApellido(),
                                        request.getDni(),
                                        request.getEmail(),
                                        passwordEncoder.encode(request.getPass()),
                                        request.getTelefono());

                        turistaRepository.save(user);
                        var jwtToken = jwtService.generateToken(user);
                        return AuthenticationResponse.builder()
                                        .accessToken(jwtToken)
                                        .build();
                } else {
                        var user = new Guia(
                                        request.getNombre(),
                                        request.getApellido(),
                                        request.getDni(),
                                        request.getEmail(),
                                        passwordEncoder.encode(request.getPass()),
                                        request.getTelefono());

                        guiaRepository.save(user);
                        var jwtToken = jwtService.generateToken(user);
                        return AuthenticationResponse.builder()
                                        .accessToken(jwtToken)
                                        .build();

                }
        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                System.out.println(request.getEmail());
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));
                System.out.println("Find by email");
                var user = repository.findByEmail(request.getEmail())
                                .orElseThrow();
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .accessToken(jwtToken)
                                .build();
        }
}
