package com.leandrainacio.workshopmongo.dto;

import java.io.Serializable;

import com.leandrainacio.workshopmongo.domain.User;

public class AutorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id ;
	private String name; 
	
	public AutorDTO() {

	}
	public AutorDTO(User objeto) {
		id = objeto.getId();
		name = objeto.getName();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
