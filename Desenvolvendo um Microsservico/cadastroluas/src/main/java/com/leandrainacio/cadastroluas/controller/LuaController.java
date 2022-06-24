package com.leandrainacio.cadastroluas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandrainacio.cadastroluas.dto.ExceptionLuaDTO;
import com.leandrainacio.cadastroluas.entity.LuaEntity;
import com.leandrainacio.cadastroluas.exception.NaoPossuiLuaException;
import com.leandrainacio.cadastroluas.service.LuaService;

@RestController
@RequestMapping(value = "/luas")
public class LuaController {

	@Autowired
	private LuaService luaservice;
	
	@GetMapping
	public List<LuaEntity> findAll() {
		return  luaservice.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> luadoPlaneta(@PathVariable("id") Long id){
		try {
			List<LuaEntity> listLuaentity = luaservice.luaDoPlaneta(id);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(listLuaentity);
		} catch (NaoPossuiLuaException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ExceptionLuaDTO(e.getMessage(),HttpStatus.NOT_FOUND));
		}
	}
	
	@PostMapping(value = "/add")
	public LuaEntity adicionandoLua(@RequestBody LuaEntity luaentity) {
		return luaservice.adicionar(luaentity);
	}
}
