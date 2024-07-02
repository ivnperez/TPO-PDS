package com.adoo2.findYourGuide2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adoo2.findYourGuide2.model.Viaje;

@Repository
public interface ViajeRepository extends CrudRepository<Viaje, Long> {
}
