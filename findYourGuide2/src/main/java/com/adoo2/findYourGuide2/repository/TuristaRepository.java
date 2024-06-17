package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.Turista;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TuristaRepository extends CrudRepository<Turista, Long> {
    List<Turista> findAll();
    Turista findById(long id);
}
