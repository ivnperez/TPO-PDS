package com.adoo2.findYourGuide2.rest;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.rest.dto.GuiaDTO;
import com.adoo2.findYourGuide2.service.GuiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/guias")
public class GuiaController {

    @Autowired
    private GuiaService guiaService;

    @GetMapping
    public List<GuiaDTO> getAllGuias() {
        List<Guia> guias = guiaService.getAllGuias();
        return guias.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @PostMapping
    public GuiaDTO createGuia(@RequestBody GuiaDTO guiaDTO) {
        Guia guia = convertToEntity(guiaDTO);
        Guia createdGuia = guiaService.createGuia(guia);
        return convertToDto(createdGuia);
    }

    private GuiaDTO convertToDto(Guia guia) {
        GuiaDTO guiaDTO = new GuiaDTO();
        guiaDTO.setId(guia.getId());
        guiaDTO.setNombre(guia.getNombre());
        guiaDTO.setDescripcion(guia.getDescripcion());
        guiaDTO.setCalificacionPromedio(guia.getCalificacionPromedio());
        return guiaDTO;
    }

    private Guia convertToEntity(GuiaDTO guiaDTO) {
        Guia guia = new Guia();
        guia.setId(guiaDTO.getId());
        guia.setNombre(guiaDTO.getNombre());
        guia.setDescripcion(guiaDTO.getDescripcion());
        guia.setCalificacionPromedio(guiaDTO.getCalificacionPromedio());
        return guia;
    }
}
