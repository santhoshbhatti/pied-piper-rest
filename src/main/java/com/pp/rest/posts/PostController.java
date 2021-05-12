package com.pp.rest.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pp.rest.posts.repo.PostRepository;

@RestController
public class PostController {
	@Autowired
	PostRepository postsRepository;

}
