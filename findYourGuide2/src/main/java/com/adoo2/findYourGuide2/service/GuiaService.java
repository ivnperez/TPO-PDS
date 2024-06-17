package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.repository.GuiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuiaService {

    @Autowired
    private GuiaRepository guiaRepository;

    public List<Guia> getAllGuias() {
        return guiaRepository.findAll();
    }

    public Guia createGuia(Guia guia) {
        return guiaRepository.save(guia);
    }
}
