package com.leandrainacio.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.leandrainacio.workshopmongo.domain.Post;
import com.leandrainacio.workshopmongo.domain.User;
import com.leandrainacio.workshopmongo.dto.AutorDTO;
import com.leandrainacio.workshopmongo.repository.PostRepository;
import com.leandrainacio.workshopmongo.repository.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null,sdf.parse("14/06/2022"), "Partiu Viajar","Estou indo para são paulo",new AutorDTO(maria));
		Post post2 = new Post(null,sdf.parse("13/06/2022"), "Hoje é segunda!","Boa semana à todos!",new AutorDTO(bob));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPost().addAll(Arrays.asList(post1));
		bob.getPost().addAll(Arrays.asList(post2));
		
		userRepository.saveAll(Arrays.asList(maria,bob));
	}
}
