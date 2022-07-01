package com.daniel.springbootmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.springbootmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<List<User>> findAll() {
		User daniel = new User("1", "Daniel", "danielmrg@gmail.com");
		User larissa = new User("2", "Larissa", "lari_vc@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(daniel, larissa));
		return ResponseEntity.ok().body(list);
	}

}
