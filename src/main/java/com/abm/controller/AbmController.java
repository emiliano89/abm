package com.abm.controller;

import com.abm.model.Request;
import com.abm.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.abm.service.AbmService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/abm")
public class AbmController {

    private final AbmService service;

    public AbmController(AbmService service) {
        this.service = service;
    }

    @GetMapping("/search/${name}")
    public ResponseEntity<Object> searchByName(@PathVariable("name") String name) {

        List<Response> responseList = service.searchByName(name);
        if (responseList.isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/search/${docType}")
    public ResponseEntity<Object> searchByDocType(@PathVariable("docType") String docType) {

        List<Response> responseList = service.searchByDocType(docType);
        if (responseList.isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Object> findAll() {

        List<Response> responseList = service.findAll();
        if (responseList.isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(responseList);
    }

    @PostMapping("/updateOrCreate")
    public ResponseEntity<Object> updateOrCreatePerson(@Valid @RequestBody Request request) {

        Optional<Response> response = service.update(request);
        if (!response.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response);
    }

}
