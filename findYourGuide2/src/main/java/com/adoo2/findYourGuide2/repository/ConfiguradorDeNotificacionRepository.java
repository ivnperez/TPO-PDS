package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.ConfiguradorDeNotificacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConfiguradorDeNotificacionRepository extends CrudRepository<ConfiguradorDeNotificacion, Long> {
    List<ConfiguradorDeNotificacion> findAll();
    ConfiguradorDeNotificacion findById(long id);
}
