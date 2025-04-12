package com.codigo.spring.repository;

import com.codigo.spring.entity.AerolineaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AerolineaRepository extends JpaRepository<AerolineaEntity, Integer> {
    @Query(value = "SELECT * FROM aerolineas WHERE nombre = :nombre LIMIT 1", nativeQuery = true)
    public AerolineaEntity findByNombre(String nombre);

}

