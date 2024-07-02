package com.adoo2.findYourGuide2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoo2.findYourGuide2.model.Calificacion;
import com.adoo2.findYourGuide2.repository.CalificacionRepository;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    public List<Calificacion> obtenerCalificaciones(Calificacion calificacion) {
        return calificacionRepository.findAll();
    }

    public Calificacion save(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }


    public Calificacion buscarCalificacion(long id) {
        return calificacionRepository.findById(id);
    }

    public List<Calificacion> buscarCalifcacionPorGuia(Long id) {
        return calificacionRepository.findByGuiaId(id);
    }
    public List<Calificacion> buscarCalifcacionPorTurista(Long id) {
        return calificacionRepository.findByTuristaId(id);
    }
    public List<Calificacion> buscarCalifcacionPorTuristaYGuia(Long turistaId, Long guiaId) {
        return calificacionRepository.findByTuristaIdAndGuiaId(turistaId, guiaId);
    }
}
