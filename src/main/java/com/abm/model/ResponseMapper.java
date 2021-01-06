package com.abm.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {

    public Response map(Persona persona) {
        Response response = new Response();
        response.setPerApellido(persona.getPerApellido());
        response.setPerFechaNacimiento(persona.getPerFechaNacimiento());
        response.setPerId(persona.getPerId());
        response.setPerNombre(persona.getPerNombre());
        response.setPerNumeroDocumento(persona.getPerNumeroDocumento());
        response.setPerTipoDocumento(persona.getPerTipoDocumento());
        return response;
    }
}
