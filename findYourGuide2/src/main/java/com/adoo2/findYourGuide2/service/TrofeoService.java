package com.adoo2.findYourGuide2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoo2.findYourGuide2.model.Trofeo;
import com.adoo2.findYourGuide2.repository.TrofeoRepository;

@Service
public class TrofeoService {

    @Autowired
    private TrofeoRepository trofeoRepository;

    public List<Trofeo> obtenerTrofeos() {
        return trofeoRepository.findAll();
    }

    public Trofeo save(Trofeo trofeo) {
        return trofeoRepository.save(trofeo);
    }


    public Trofeo buscarCalificacion(long id) {
        return trofeoRepository.findById(id);
    }

    public List<Trofeo> buscarTrofeoPorUsuario(Long id) {
        return trofeoRepository.findByUsuarioId(id);
    }
}
