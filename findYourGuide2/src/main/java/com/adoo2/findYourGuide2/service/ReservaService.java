package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Reserva;
import com.adoo2.findYourGuide2.repository.ReservaRepository;
import com.adoo2.findYourGuide2.repository.TuristaRepository;
import com.adoo2.findYourGuide2.repository.GuiaRepository;
import com.adoo2.findYourGuide2.rest.dto.CrearReservaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private TuristaRepository turistaRepository;

    @Autowired
    private GuiaRepository guiaRepository;

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva createReserva(CrearReservaDTO crearReservaDTO) {
        Reserva reserva = new Reserva();
        reserva.setTurista(turistaRepository.findById(crearReservaDTO.getTuristaId()).orElse(null));
        reserva.setGuia(guiaRepository.findById(crearReservaDTO.getGuiaId()).orElse(null));
        reserva.setFechaHora(crearReservaDTO.getFechaHora());
        reserva.setEstado("Pendiente"); // o el estado inicial deseado
        return reservaRepository.save(reserva);
    }
}
