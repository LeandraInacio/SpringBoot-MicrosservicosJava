package com.leandrainacio.cadastroluas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leandrainacio.cadastroluas.entity.LuaEntity;

@Repository
public interface LuaRepository extends JpaRepository<LuaEntity, Long>{

	@Query("SELECT l FROM LuaEntity l WHERE l.idPlaneta = :pId")
	public Optional<List<LuaEntity>> buscarLuaPorIdPlaneta(@Param("pId") Long id);
}
