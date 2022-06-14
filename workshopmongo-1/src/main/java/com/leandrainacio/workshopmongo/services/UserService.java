package com.leandrainacio.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandrainacio.workshopmongo.domain.User;
import com.leandrainacio.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public Optional<User> findById (String id) {
		Optional<User> user = repo.findById(id);
		if(user == null) {
			throw new NotFoundException("Objeto não encontrado");
		}
		return user;
	}
	
}
