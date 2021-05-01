package com.pp.rest.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pp.rest.posts.repo.PostsRepo;

@RestController
public class PostController {
	@Autowired
	PostsRepo postsRepo;
	
	@GetMapping("/users/{userid}/posts")
	public ResponseEntity<Object> getAllUserPosts(@PathVariable("userid")int userId){
		List<Post> posts=postsRepo.getUserPost(userId);
		if(posts!=null && !posts.isEmpty()) {
			return ResponseEntity.ok(posts);
		}
		return ResponseEntity.notFound().build();
	}

}
