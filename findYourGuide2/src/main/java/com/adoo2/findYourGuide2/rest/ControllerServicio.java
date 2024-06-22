package com.adoo2.findYourGuide2.rest;

import com.adoo2.findYourGuide2.rest.dto.TourIndividualDTO;
import com.adoo2.findYourGuide2.rest.dto.TourGrupalDTO;
import com.adoo2.findYourGuide2.rest.dto.TraduccionDTO;
import com.adoo2.findYourGuide2.model.Servicios_Ofrecidos;
import com.adoo2.findYourGuide2.service.ServiciosOfrecidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicios")
public class ControllerServicio {

    @Autowired
    private ServiciosOfrecidosService serviciosOfrecidosService;

    @PostMapping("/individual")
    public void agregarServicioIndividual(@RequestBody TourIndividualDTO servicio) {
        serviciosOfrecidosService.agregarServicioIndividual(servicio);
    }

    @DeleteMapping("/individual")
    public void eliminarServicioIndividual(@RequestBody TourIndividualDTO servicio) {
        serviciosOfrecidosService.eliminarServicioIndividual(servicio);
    }

    @PostMapping("/grupal")
    public void agregarServicioGrupal(@RequestBody TourGrupalDTO servicio) {
        serviciosOfrecidosService.agregarServicioGrupal(servicio);
    }

    @DeleteMapping("/grupal")
    public void eliminarServicioGrupal(@RequestBody TourGrupalDTO servicio) {
        serviciosOfrecidosService.eliminarServicioGrupal(servicio);
    }

    @PostMapping("/traduccion")
    public void agregarTraduccion(@RequestBody TraduccionDTO servicio) {
        serviciosOfrecidosService.agregarTraduccion(servicio);
    }

    @DeleteMapping("/traduccion")
    public void eliminarTraduccion(@RequestBody TraduccionDTO servicio) {
        serviciosOfrecidosService.eliminarTraduccion(servicio);
    }
}
