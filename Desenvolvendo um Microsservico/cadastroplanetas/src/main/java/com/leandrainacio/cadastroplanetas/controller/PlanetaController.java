package com.leandrainacio.cadastroplanetas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandrainacio.cadastroplanetas.dto.ExceptionDTO;
import com.leandrainacio.cadastroplanetas.dto.PlanetaDTO;
import com.leandrainacio.cadastroplanetas.entity.LuaEntity;
import com.leandrainacio.cadastroplanetas.entity.PlanetaEntity;
import com.leandrainacio.cadastroplanetas.exception.IdNaoEncontradoException;
import com.leandrainacio.cadastroplanetas.mapper.PlanetaMapper;
import com.leandrainacio.cadastroplanetas.service.LuaService;
import com.leandrainacio.cadastroplanetas.service.PlanetaService;

@RestController
@RequestMapping(value = "/planetas")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaservice;
	
	@Autowired
	private LuaService luaservice;
	
	@GetMapping
	public List<PlanetaEntity> buscaTodosPlanetas() {
		return planetaservice.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> buscaPorId(@PathVariable("id") Long id) {
		try {
			PlanetaEntity planetaId = planetaservice.findById(id);
			List<LuaEntity> luas = luaservice.buscaLuaPorIdPlaneta(id);
			
			PlanetaDTO planetaDTO = PlanetaMapper.toContatoDto(planetaId, luas);
			
			return ResponseEntity.status(HttpStatus.OK).body(planetaDTO);	
		}catch (IdNaoEncontradoException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ExceptionDTO(e.getMessage(), HttpStatus.NOT_FOUND));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
