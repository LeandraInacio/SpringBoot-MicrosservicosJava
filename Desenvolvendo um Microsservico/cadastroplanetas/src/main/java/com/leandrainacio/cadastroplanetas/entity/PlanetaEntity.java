package com.leandrainacio.cadastroplanetas.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlanetaEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String nome;
	private Long massa;
	private int posicao;
	
	public PlanetaEntity() {
		
	}

	public PlanetaEntity(Long id, String nome, Long massa, int posicao) {
		super();
		this.id = id;
		this.nome = nome;
		this.massa = massa;
		this.posicao = posicao;
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

	public Long getMassa() {
		return massa;
	}

	public void setMassa(Long massa) {
		this.massa = massa;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
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
		PlanetaEntity other = (PlanetaEntity) obj;
		return Objects.equals(id, other.id);
	}
}
