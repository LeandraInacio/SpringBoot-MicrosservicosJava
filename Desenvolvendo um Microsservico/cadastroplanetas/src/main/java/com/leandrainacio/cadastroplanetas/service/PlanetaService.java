package com.leandrainacio.cadastroplanetas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandrainacio.cadastroplanetas.entity.PlanetaEntity;
import com.leandrainacio.cadastroplanetas.exception.IdNaoEncontradoException;
import com.leandrainacio.cadastroplanetas.repository.PlanetasRepository;

@Service
public class PlanetaService {
	
	@Autowired
	private PlanetasRepository planetaRepository;
	
	public List<PlanetaEntity> findAll() {
		return planetaRepository.findAll();
	}
	
	public PlanetaEntity findById(Long id) throws IdNaoEncontradoException {
		Optional<PlanetaEntity> planetaOptional = planetaRepository.findById(id);		
		if(planetaOptional.isEmpty()) {
			throw new IdNaoEncontradoException("Planeta não encontrado para o Id "+ id);
		}else {
			PlanetaEntity planetaEntity = planetaOptional.get();
			return planetaEntity;
		}
	}
}
