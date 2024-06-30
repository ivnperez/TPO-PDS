package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.repository.TuristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuristaService {

    @Autowired
    private TuristaRepository turistaRepository;

    public List<Turista> obtenerTurista(Turista turista) {
        return turistaRepository.findAll();
    }

    public Turista save(Turista turista) {
        return turistaRepository.save(turista);
    }
}
