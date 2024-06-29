package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Calificacion;
import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.Usuario;
import com.adoo2.findYourGuide2.repository.GuiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuiaService {

    @Autowired
    private GuiaRepository guiaRepository;

    public List<Guia> obtenerGuia(Guia guia) {
        return guiaRepository.findAll();
    }
    public Guia save(Guia guia) {
        return guiaRepository.save(guia);
    }


    public void agregarCalificacion(Calificacion calificacion, Long guiaId) {
        Optional<Guia> guiaOptional = guiaRepository.findById(guiaId);
        if (guiaOptional.isPresent()) {
            Guia guia = guiaOptional.get();
            guia.getCalificaciones().add(calificacion);
            calificacion.setGuia(guia);
            guiaRepository.save(guia);
        }
    }

    public List<Guia> buscarGuia(String nombre, String apellido) {
        return guiaRepository.findByNombreContainingOrApellidoContaining(nombre, apellido);
    }
}
