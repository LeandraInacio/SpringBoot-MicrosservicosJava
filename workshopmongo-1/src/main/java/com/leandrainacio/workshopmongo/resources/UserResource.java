package com.leandrainacio.workshopmongo.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandrainacio.workshopmongo.domain.User;
import com.leandrainacio.workshopmongo.dto.UserDTO;
import com.leandrainacio.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<UserDTO> findAll(){
		List<User> lista = service.findAll();
		List<UserDTO>  listaDTO = lista.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return listaDTO;		
	}
	
	@GetMapping(value = "/{id}")
	public Optional<User> findById(@PathVariable String id){
		Optional<User> objeto = service.findById(id);
		//UserDTO userDTO = new UserDTO(objeto);
		return objeto;		
	}
}
