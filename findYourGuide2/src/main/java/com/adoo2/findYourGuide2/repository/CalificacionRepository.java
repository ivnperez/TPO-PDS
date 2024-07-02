package com.adoo2.findYourGuide2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adoo2.findYourGuide2.model.Calificacion;

public interface CalificacionRepository extends CrudRepository<Calificacion, Long> {
    List<Calificacion> findAll();
    Calificacion findById(long id);

    List<Calificacion> findByGuiaId(Long guia_id);
    List<Calificacion> findByTuristaId(Long turista_id);
    List<Calificacion> findByTuristaIdAndGuiaId(Long turistaId, Long guiaId);
}
