package com.pp.rest.posts.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.pp.rest.posts.Post;
@Component
public class PostsRepo {
	
	private List<Post> posts=new ArrayList<>();
	{
		posts.add(new Post(1, "Hello world !!!!", 1));
		posts.add(new Post(2, "Hello Bangalore", 1));
		posts.add(new Post(3, "Hello Sagar", 2));
		posts.add(new Post(4, "Hello Shimoga", 2));
		posts.add(new Post(5, "Hello Mars", 3));
		posts.add(new Post(6, "Hello Jupiter", 4));
	}
	AtomicInteger pid=new AtomicInteger(6);
	
	public Post getPostById(final int id) {
		Optional<Post> op=posts.stream().filter(p -> p.getId().equals(id)).findFirst();
		if(op.isPresent()) return op.get();
		return null;
	}
	
	public Post savePost(Post p) {
		if(p.getId() == null) {
			p.setId(pid.incrementAndGet());
		}
		posts.add(p);
		return p;
	}
	
	public List<Post> getUserPost(Integer userid){
		return posts.stream()
				.filter(p -> p.getUserid().equals(userid))
				.collect(Collectors.toList());	
	}
	

}
