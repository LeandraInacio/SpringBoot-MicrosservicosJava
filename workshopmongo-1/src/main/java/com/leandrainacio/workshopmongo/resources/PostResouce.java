package com.leandrainacio.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leandrainacio.workshopmongo.domain.Post;
import com.leandrainacio.workshopmongo.resources.util.URL;
import com.leandrainacio.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResouce {

	@Autowired
	private PostService service;
	
	@GetMapping(value = "titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value ="text", defaultValue="") String text){
		text = URL.decodeParam(text);
		List<Post> list =  service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
