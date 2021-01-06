package com.abm.model;

import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {
    public Persona map(Request request) {
        Persona persona = new Persona();
        persona.setPerApellido(request.getPerApellido().toLowerCase());
        persona.setPerFechaNacimiento(request.getPerFechaNacimiento());
        persona.setPerId(request.getPerId());
        persona.setPerNombre(request.getPerNombre().toLowerCase());
        persona.setPerNumeroDocumento(request.getPerNumeroDocumento());
        persona.setPerTipoDocumento(request.getPerTipoDocumento().toUpperCase());
        return persona;
    }
}
