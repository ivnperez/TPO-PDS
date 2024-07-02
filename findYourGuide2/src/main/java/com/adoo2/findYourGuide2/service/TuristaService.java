package com.adoo2.findYourGuide2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoo2.findYourGuide2.model.Turista;
import com.adoo2.findYourGuide2.repository.TuristaRepository;

@Service
public class TuristaService {

    @Autowired
    private TuristaRepository turistaRepository;

    public List<Turista> obtenerTuristas(Turista turista) {
        return turistaRepository.findAll();
    }

    public Turista save(Turista turista) {
        return turistaRepository.save(turista);
    }


    public Turista buscarTurista(long id) {
        return turistaRepository.findById(id);
    }
}
