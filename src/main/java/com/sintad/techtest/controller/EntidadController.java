package com.sintad.techtest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sintad.techtest.model.Entidad;
import com.sintad.techtest.service.EntidadService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/entidad/")
public class EntidadController {
    
    @Autowired
    private EntidadService entidadService;

    @GetMapping
    private ResponseEntity<List<Entidad>> getAllEntidad() {
        return ResponseEntity.ok(entidadService.findAll());
    }
    
    @GetMapping("{id}")
    private ResponseEntity<Optional<Entidad>> getEntidad(@PathVariable("id") int entidadId) {
        return ResponseEntity.ok(entidadService.findById(entidadId));
    }
    
    @PostMapping
    private ResponseEntity<?> createEntidad(@Valid @RequestBody Entidad nuevaEntidad, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.ok(entidadService.createNewEntidad(nuevaEntidad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Entidad entidad) {
        return ResponseEntity.ok(entidadService.updateEntidad(id, entidad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        entidadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
