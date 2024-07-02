package com.adoo2.findYourGuide2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adoo2.findYourGuide2.model.Trofeo;

public interface TrofeoRepository extends CrudRepository<Trofeo, Long> {
    List<Trofeo> findAll();
    Trofeo findById(long id);

    List<Trofeo> findByUsuarioId(Long usuario_id);
   
}
