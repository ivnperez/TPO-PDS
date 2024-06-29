package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.Servicio;
import com.adoo2.findYourGuide2.model.Servicios_Ofrecidos;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Servicios_OfrecidosRepository extends CrudRepository<Servicios_Ofrecidos, Long> {
    List<Servicios_Ofrecidos> findAll();

    Servicio findById(long id);
}
