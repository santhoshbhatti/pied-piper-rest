package com.pp.rest.users.persistent.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pp.rest.users.exceptions.UserNotFoundException;
import com.pp.rest.users.persistent.daos.UsersRepository;
import com.pp.rest.users.vos.User;

@RestController
public class PersistentUserController {
	@Autowired
	UsersRepository userRepository;
	
	@GetMapping("/app/users/{id}")
	public EntityModel<User> getUser(@PathVariable("id")int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id-"+id);
		}
		EntityModel<User> resource=EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
		resource.add(link.withRel("all-users"));		
		return resource;
	}
	
	

	@GetMapping("/app/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	@PostMapping("/app/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser=userRepository.save(user);
		URI uri=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping("/app/users/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userRepository.deleteById(id);
	}

}
