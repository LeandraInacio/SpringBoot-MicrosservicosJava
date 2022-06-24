package com.leandrainacio.cadastroplanetas.dto;

import java.util.List;
import java.util.Objects;

import com.leandrainacio.cadastroplanetas.entity.LuaEntity;
import com.leandrainacio.cadastroplanetas.entity.PlanetaEntity;

public class PlanetaDTO {
	
	private Long id;
	private String nome;
	private List<LuaEntity> lua;
	
	public PlanetaDTO() {
		
	}

	public PlanetaDTO(PlanetaEntity obj, List<LuaEntity> lua) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.lua = lua;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LuaEntity> getLua() {
		return lua;
	}

	public void setLua(List<LuaEntity> lua) {
		this.lua = lua;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanetaDTO other = (PlanetaDTO) obj;
		return Objects.equals(id, other.id);
	}
}
