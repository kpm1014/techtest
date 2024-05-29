package com.sintad.techtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sintad.techtest.model.TipoContribuyente;

@Repository
public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Integer>{
}
