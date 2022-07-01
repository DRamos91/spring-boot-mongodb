package com.daniel.springbootmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.springbootmongo.domain.User;
import com.daniel.springbootmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private  UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	
}
