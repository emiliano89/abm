package com.abm.service;

import com.abm.model.Persona;
import com.abm.model.PersonaMapper;
import com.abm.model.Request;
import com.abm.model.Response;
import com.abm.model.ResponseMapper;
import com.abm.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@ComponentScan("com.abm")
public class AbmService {

    // Se agrego el autowired aunque este por constructor porque no toma el bean del repository
    @Autowired
    @Lazy
    private final PersonaRepository repository;
    private final ResponseMapper responseMapper;
    private final PersonaMapper personaMapper;


    public AbmService(PersonaRepository repository, ResponseMapper responseMapper, PersonaMapper personaMapper) {
        this.repository = repository;
        this.responseMapper = responseMapper;
        this.personaMapper = personaMapper;
    }

    public List<Response> searchByName(String request) {
        List<Persona> persona = repository.findByPerNombre(request.toLowerCase());
        if (persona.isEmpty()) {
            return Collections.emptyList();
        }
        return persona.stream().map(responseMapper::map).collect(Collectors.toList());
    }

    public List<Response> searchByDocType(String request) {
        List<Persona> persona = repository.findByPerTipoDocumento(request.toUpperCase());
        if (persona.isEmpty()) {
            return Collections.emptyList();
        }
        return persona.stream().map(responseMapper::map).collect(Collectors.toList());
    }

    public List<Response> findAll() {
        List<Persona> persona = repository.findAll();
        if (persona.isEmpty()) {
            return Collections.emptyList();
        }
        return persona.stream().map(responseMapper::map).collect(Collectors.toList());
    }

    public Optional<Response> update(Request request) {
        try {
            Persona persona = repository.save(personaMapper.map(request));
            return Optional.of(responseMapper.map(persona));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
