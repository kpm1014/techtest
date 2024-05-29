package com.sintad.techtest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sintad.techtest.model.TipoContribuyente;
import com.sintad.techtest.service.TipoContribuyenteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tipo-contribuyente/")
public class TipoContribuyenteController {
    
    @Autowired
    private TipoContribuyenteService tipoContribuyenteService;

    @GetMapping
    private ResponseEntity<List<TipoContribuyente>> getAllTipoContribuyente() {
        return ResponseEntity.ok(tipoContribuyenteService.findAll());
    }
        
    @GetMapping("{id}")
    public ResponseEntity<Optional<TipoContribuyente>> getTipoContribuyente(@PathVariable("id") int tipoContribuyenteId) {
        return ResponseEntity.ok(tipoContribuyenteService.findById(tipoContribuyenteId));
    }

    @PostMapping
    private ResponseEntity<?> createTipoContribuyente(@Valid @RequestBody TipoContribuyente nuevoTipoContribuyente, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.ok(tipoContribuyenteService.createNewTipoContribuyente(nuevoTipoContribuyente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody TipoContribuyente entidad) {
        return ResponseEntity.ok(tipoContribuyenteService.updateTipoContribuyente(id, entidad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        tipoContribuyenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
