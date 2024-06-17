package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.MetodoDePago;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MetodoDePagoRepository extends CrudRepository<MetodoDePago, Long> {
    List<MetodoDePago> findAll();
    MetodoDePago findById(long id);
}
