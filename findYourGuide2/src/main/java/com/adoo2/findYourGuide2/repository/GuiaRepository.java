package com.adoo2.findYourGuide2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adoo2.findYourGuide2.model.Guia;

@Repository
public interface GuiaRepository extends JpaRepository<Guia, Long> {
    List<Guia> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Guia findById(long id);
    List<Guia> findAll();
}


