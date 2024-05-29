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

import com.sintad.techtest.model.TipoDocumento;
import com.sintad.techtest.service.TipoDocumentoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tipo-documento/")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    private ResponseEntity<List<TipoDocumento>> getAllTipoDocumento() {
        return ResponseEntity.ok(tipoDocumentoService.findAll());
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Optional<TipoDocumento>> getTipoDocumento(@PathVariable("id") int tipoDocumentoId) {
        return ResponseEntity.ok(tipoDocumentoService.findById(tipoDocumentoId));
    }

    @PostMapping
    private ResponseEntity<?> createTipoDocumento(@Valid @RequestBody TipoDocumento nuevoTipoDocumento, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.ok(tipoDocumentoService.createNewTipoDocumento(nuevoTipoDocumento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody TipoDocumento entidad) {
        return ResponseEntity.ok(tipoDocumentoService.updateTipoDocumento(id, entidad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        tipoDocumentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
