package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.Factura;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacturaRepository extends CrudRepository<Factura, Long> {
    List<Factura> findAll();
    Factura findById(long id);
}
