package com.sintad.techtest.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sintad.techtest.exception.ResourceNotFoundException;
import com.sintad.techtest.model.Entidad;
import com.sintad.techtest.repository.EntidadRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class EntidadServiceTest {

    @Mock
    private EntidadRepository entidadRepository;

    @InjectMocks
    private EntidadService entidadService;

    public EntidadServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {

        List<Entidad> entities = new ArrayList<>();
        when(entidadRepository.findAll()).thenReturn(entities);

        List<Entidad> result = entidadService.findAll();

        assertEquals(entities, result);
        verify(entidadRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {

        int entityId = 3;
        Entidad entity = new Entidad();
        when(entidadRepository.findById(entityId)).thenReturn(Optional.of(entity));

        Entidad result = entidadService.findById(entityId).orElse(null);

        assertEquals(entity, result);
        verify(entidadRepository, times(1)).findById(entityId);
    }

    @Test
    public void testFindById_EntityNotFound() {

        int entityId = 1;
        when(entidadRepository.findById(entityId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> entidadService.findById(entityId));
        verify(entidadRepository, times(1)).findById(entityId);
    }

    @Test
    public void testCreateNewEntidad() {

        Entidad entity = new Entidad();
        when(entidadRepository.save(entity)).thenReturn(entity);

        Entidad result = entidadService.createNewEntidad(entity);

        assertEquals(entity, result);
        verify(entidadRepository, times(1)).save(entity);
    }

    @Test
    public void testUpdateEntidad() {

        int entityId = 1;
        Entidad entity = new Entidad();
        when(entidadRepository.findById(entityId)).thenReturn(Optional.of(entity));
        when(entidadRepository.saveAndFlush(entity)).thenReturn(entity);

        Entidad result = entidadService.updateEntidad(entityId, entity);

        assertEquals(entity, result);
        verify(entidadRepository, times(1)).findById(entityId);
        verify(entidadRepository, times(1)).saveAndFlush(entity);
    }

    // @Test
    // public void testDeleteById() {

    //     List<Entidad> lista =  entidadService.findAll();
    //     int entityId = lista.get(0).getIdEntidad();

    //     entidadService.deleteById(entityId);

    //     verify(entidadRepository, times(1)).findById(entityId);
    //     verify(entidadRepository, times(1)).deleteById(entityId);
    // }

    @Test
    public void testDeleteById_EntityNotFound() {

        int entityId = 1;
        when(entidadRepository.findById(entityId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> entidadService.deleteById(entityId));
        verify(entidadRepository, times(1)).findById(entityId);
        verify(entidadRepository, never()).deleteById(entityId);
    }
}