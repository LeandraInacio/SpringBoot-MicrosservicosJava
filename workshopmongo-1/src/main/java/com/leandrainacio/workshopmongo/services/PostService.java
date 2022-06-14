package com.leandrainacio.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandrainacio.workshopmongo.domain.Post;
import com.leandrainacio.workshopmongo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public List<Post> findByTitle (String text){
		return repo.findByTitleContaining(text); 
	}
}
