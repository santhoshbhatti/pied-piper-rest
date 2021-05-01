package com.pp.rest.users.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pp.rest.users.exceptions.UserNotFoundException;
import com.pp.rest.users.repo.UsersDao;
import com.pp.rest.users.vos.User;

import io.swagger.annotations.ApiModel;

@RestController
public class UserController {
	@Autowired
	UsersDao userDao;
	
	@GetMapping("/users/{id}")
	public EntityModel<User> getUser(@PathVariable("id")int id) {
		User user = userDao.getUser(id);
		if(user == null) {
			throw new UserNotFoundException("id-"+id);
		}
		EntityModel<User> resource=EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
		resource.add(link.withRel("all-users"));		
		return resource;
	}
	
	

	@GetMapping("/users")
	public List<User> getUsers() {
		return userDao.getAllUsers();
	}
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser=userDao.saveUser(user);
		URI uri=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
		
	}
}
