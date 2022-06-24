package com.leandrainacio.cadastroluas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandrainacio.cadastroluas.entity.LuaEntity;
import com.leandrainacio.cadastroluas.exception.NaoPossuiLuaException;
import com.leandrainacio.cadastroluas.repository.LuaRepository;

@Service
public class LuaService {

	@Autowired
	private LuaRepository luarepository;
	
	public List<LuaEntity> findAll(){
		return luarepository.findAll();
	}
	
	public List<LuaEntity> luaDoPlaneta(Long id) throws NaoPossuiLuaException {
		Optional<List<LuaEntity>> optionalListLua = luarepository.buscarLuaPorIdPlaneta(id);
		List<LuaEntity> listLua = optionalListLua.get();
		if(listLua.isEmpty()) {
			throw new NaoPossuiLuaException("Não existe Lua para o planeta de Id: "+id);
		}else {
			return listLua;
		}
	}
	
	public LuaEntity adicionar(LuaEntity luaentity) {
		return luarepository.save(luaentity);
	}
}
