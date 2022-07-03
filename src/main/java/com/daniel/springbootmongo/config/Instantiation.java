package com.daniel.springbootmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.daniel.springbootmongo.domain.Post;
import com.daniel.springbootmongo.domain.User;
import com.daniel.springbootmongo.dto.AuthorDTO;
import com.daniel.springbootmongo.repository.PostRepository;
import com.daniel.springbootmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

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
		
		User daniel = new User(null, "Daniel", "danielmrg@gmail.com");
		User larissa = new User(null, "Larissa", "larissa@gmail.com");
		User patricia = new User(null, "Patricia", "patricia@gmail.com");
		
		userRepository.saveAll(Arrays.asList(daniel, larissa, patricia));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(daniel));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(daniel));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
	
}
