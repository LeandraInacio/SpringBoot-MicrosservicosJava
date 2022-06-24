package com.leandrainacio.cadastroplanetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandrainacio.cadastroplanetas.entity.PlanetaEntity;

@Repository
public interface PlanetasRepository extends JpaRepository<PlanetaEntity, Long>{

}
