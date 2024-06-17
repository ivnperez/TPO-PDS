package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.Mensaje;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MensajeRepository extends CrudRepository<Mensaje, Long> {
    List<Mensaje> findAll();
    Mensaje findById(long id);
}
