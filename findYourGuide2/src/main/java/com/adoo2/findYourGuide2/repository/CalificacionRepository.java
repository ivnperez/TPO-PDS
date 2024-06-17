package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.Calificacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalificacionRepository extends CrudRepository<Calificacion, Long> {
    List<Calificacion> findAll();
    Calificacion findById(long id);
}
