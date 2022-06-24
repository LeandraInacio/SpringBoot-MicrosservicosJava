package com.leandrainacio.cadastroluas.dto;

import org.springframework.http.HttpStatus;

public class ExceptionLuaDTO {

	private String mensagem;
	private HttpStatus status;
	
	public ExceptionLuaDTO(String mensagem, HttpStatus status) {
		this.mensagem = mensagem;
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ExceptionLuaDTO [mensagem=" + mensagem + ", status=" + status + "]";
	}
}
