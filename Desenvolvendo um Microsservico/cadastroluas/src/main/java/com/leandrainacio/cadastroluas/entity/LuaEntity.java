package com.leandrainacio.cadastroluas.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LuaEntity {

	@Id
	private Long idLua;
	private String nomeLua;
	private Long idPlaneta;
	
	public LuaEntity() {
		
	}
	public LuaEntity(Long idLua, String nomeLua, Long idPlaneta) {
		super();
		this.idLua = idLua;
		this.nomeLua = nomeLua;
		this.idPlaneta = idPlaneta;
	}
	public Long getIdLua() {
		return idLua;
	}
	public void setIdLua(Long idLua) {
		this.idLua = idLua;
	}
	public String getNomeLua() {
		return nomeLua;
	}
	public void setNomeLua(String nomeLua) {
		this.nomeLua = nomeLua;
	}
	public Long getIdPlaneta() {
		return idPlaneta;
	}
	public void setIdPlaneta(Long idPlaneta) {
		this.idPlaneta = idPlaneta;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idLua);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LuaEntity other = (LuaEntity) obj;
		return Objects.equals(idLua, other.idLua);
	}
}
