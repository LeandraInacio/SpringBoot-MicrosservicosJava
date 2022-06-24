package com.leandrainacio.cadastroplanetas.dto;

import org.springframework.http.HttpStatus;

public class ExceptionDTO {

	private String erro;
	private HttpStatus status;
	
	public ExceptionDTO(String erro, HttpStatus status) {
		this.erro = erro;
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ExceptionDTO [erro=" + erro + ", status=" + status + "]";
	}
}
