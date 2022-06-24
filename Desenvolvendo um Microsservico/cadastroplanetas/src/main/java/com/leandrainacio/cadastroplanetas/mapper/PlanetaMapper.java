package com.leandrainacio.cadastroplanetas.mapper;

import java.util.List;

import com.leandrainacio.cadastroplanetas.dto.PlanetaDTO;
import com.leandrainacio.cadastroplanetas.entity.LuaEntity;
import com.leandrainacio.cadastroplanetas.entity.PlanetaEntity;

public class PlanetaMapper {

	public static PlanetaDTO toContatoDto(PlanetaEntity contatoEntity, List<LuaEntity> luas) {
		PlanetaDTO dto = new PlanetaDTO();
		dto.setId(contatoEntity.getId());
		dto.setNome(contatoEntity.getNome());
		dto.setLua(luas);
		return dto;
	}
}
