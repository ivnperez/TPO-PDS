package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.rest.dto.TourIndividualDTO;
import com.adoo2.findYourGuide2.rest.dto.TourGrupalDTO;
import com.adoo2.findYourGuide2.rest.dto.TraduccionDTO;
import com.adoo2.findYourGuide2.model.Servicios_Ofrecidos;
import com.adoo2.findYourGuide2.model.TourGrupal;
import com.adoo2.findYourGuide2.model.TourIndividual;
import com.adoo2.findYourGuide2.model.Traduccion;
import org.springframework.stereotype.Service;

@Service
public class ServiciosOfrecidosService {

    public void agregarServicioIndividual(TourIndividualDTO servicioDTO) {
        Servicios_Ofrecidos servicio = new Servicios_Ofrecidos();
        servicio.setDescripcion(servicioDTO.getDescripcion());
        // servicio.setPrecio(servicioDTO.getPrecio()); // Ajustar si
        // `Servicios_Ofrecidos` tiene precio
        servicio.setZona(servicioDTO.getZona());
        servicio.setTipo(new TourIndividual());
        // Guardar servicio en la base de datos
    }

    public void eliminarServicioIndividual(TourIndividualDTO servicioDTO) {
        // Lógica para eliminar un servicio individual
    }

    public void agregarServicioGrupal(TourGrupalDTO servicioDTO) {
        Servicios_Ofrecidos servicio = new Servicios_Ofrecidos();
        servicio.setDescripcion(servicioDTO.getDescripcion());
        // servicio.setPrecio(servicioDTO.getPrecio()); // Ajustar si
        // `Servicios_Ofrecidos` tiene precio
        servicio.setZona(servicioDTO.getZona());
        servicio.setTamMaxGrupo(servicioDTO.getTamMaxGrupo());
        servicio.setTipo(new TourGrupal());
        // Guardar servicio en la base de datos
    }

    public void eliminarServicioGrupal(TourGrupalDTO servicioDTO) {
        // Lógica para eliminar un servicio grupal
    }

    public void agregarTraduccion(TraduccionDTO servicioDTO) {
        Servicios_Ofrecidos servicio = new Servicios_Ofrecidos();
        servicio.setDescripcion(servicioDTO.getDescripcion());
        // servicio.setPrecio(servicioDTO.getPrecio()); // Ajustar si
        // `Servicios_Ofrecidos` tiene precio
        servicio.setZona(servicioDTO.getZona());
        servicio.setIdiomas(servicioDTO.getIdiomas());
        servicio.setTipo(new Traduccion());
        // Guardar servicio en la base de datos
    }

    public void eliminarTraduccion(TraduccionDTO servicioDTO) {
        // Lógica para eliminar un servicio de traducción
    }
}
