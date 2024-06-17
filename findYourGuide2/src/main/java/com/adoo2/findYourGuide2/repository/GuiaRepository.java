package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.Guia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuiaRepository extends CrudRepository<Guia, Long> {
    List<Guia> findAll();
    Guia findById(long id);
}
