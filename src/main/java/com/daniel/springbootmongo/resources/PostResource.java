package com.daniel.springbootmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.springbootmongo.domain.Post;
import com.daniel.springbootmongo.resources.util.URL;
import com.daniel.springbootmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired

	private PostService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	private ResponseEntity<List<Post>> findByTitle(@RequestParam (value="text", defaultValue = "")String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	private ResponseEntity<List<Post>> fullSearch(@RequestParam (value="text", defaultValue = "")String text, 
			@RequestParam (value="minDate", defaultValue = "")String minDate,
			@RequestParam (value="maxDate", defaultValue = "")String maxDate){
		text = URL.decodeParam(text);
		Date min = URL.converteDate(minDate, new Date(0L));
		Date max = URL.converteDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
}
