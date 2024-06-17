package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.ControladorCredencial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ControladorCredencialRepository extends CrudRepository<ControladorCredencial, Long> {
    List<ControladorCredencial> findAll();
    ControladorCredencial findById(long id);
}
