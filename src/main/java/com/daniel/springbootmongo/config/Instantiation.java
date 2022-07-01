package com.daniel.springbootmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.daniel.springbootmongo.domain.User;
import com.daniel.springbootmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User daniel = new User(null, "Daniel", "danielmrg@gmail.com");
		User larissa = new User(null, "Larissa", "larissa@gmail.com");
		User patricia = new User(null, "Patricia", "patricia@gmail.com");
		
		userRepository.saveAll(Arrays.asList(daniel, larissa, patricia));
	}
	
}
