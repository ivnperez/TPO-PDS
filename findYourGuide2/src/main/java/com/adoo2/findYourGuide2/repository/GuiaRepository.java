package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.Guia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuiaRepository extends JpaRepository<Guia, Long> {
    List<Guia> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
}
