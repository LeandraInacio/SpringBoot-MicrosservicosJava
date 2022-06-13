package com.leandrainacio.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandrainacio.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping
	public List<User> findAll(){
		User usuario1 = new User("1", "Maria", "maria@email.com");
		User usuario2 = new User("2", "João", "joao@email.com");
		
		List<User> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(usuario1, usuario2));
		
		return lista;		
	}
}
