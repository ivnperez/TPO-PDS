package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Credencial;
import org.springframework.stereotype.Service;

@Service
public class AdapterVerificador implements IAdapterVerificadorCredencial {

    @Override
    public boolean verificarCredencial(Credencial credencial) {
        // Lógica para verificar la credencial
        return true; // Implementación pendiente
    }
}
