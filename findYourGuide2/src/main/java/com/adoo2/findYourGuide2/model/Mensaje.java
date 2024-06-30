package com.adoo2.findYourGuide2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje {
    private String mensaje;
    private Usuario mandadoPor;
}
