package com.pp.rest.users.persistent.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pp.rest.posts.Post;
import com.pp.rest.posts.repo.PostRepository;
import com.pp.rest.users.exceptions.UserNotFoundException;
import com.pp.rest.users.persistent.daos.UsersRepository;
import com.pp.rest.users.vos.User;

@RestController
public class PersistentPostController {
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UsersRepository userRepository;
	
	
	@GetMapping("/app/users/{userid}/posts")
	public List<Post> getUserPosts(@PathVariable("userid") int userId){
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()) {
			throw new UserNotFoundException("user "+userId+" not found");
		}
		
		return user.get().getPosts();
	}
	
	@GetMapping("/app/users/{userid}/posts/{postid}")
	public Post getUserPostById(@PathVariable("userid") int userId,@PathVariable("postid") int postid){
		Optional<Post> post = postRepository.findById(postid);
		if(post.isEmpty()) {
			throw new UserNotFoundException("user "+userId+" not found");
		}
		
		return post.get();
	}
	
	@PostMapping("/app/users/{userid}/posts")
	public ResponseEntity<Object> createPost(@PathVariable("userid") int userid,@org.springframework.web.bind.annotation.RequestBody Post post){
		
		Optional<User> user = userRepository.findById(userid);
		if(user.isEmpty()) {
			throw new UserNotFoundException("user "+userid+" not found");
		}
		
		post.setUser(user.get());
		postRepository.save(post);
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{userid}").buildAndExpand(post.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
		
	}
	
}
