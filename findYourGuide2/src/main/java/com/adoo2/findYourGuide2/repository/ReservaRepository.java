package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.Reserva;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservaRepository extends CrudRepository<Reserva, Long> {
    List<Reserva> findAll();
    Reserva findById(long id);
}
