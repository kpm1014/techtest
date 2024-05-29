package com.sintad.techtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sintad.techtest.model.Entidad;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Integer>{
}
