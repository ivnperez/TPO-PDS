package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.Servicio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServicioRepository extends CrudRepository<Servicio, Long> {
    List<Servicio> findAll();
    Servicio findById(long id);
}
