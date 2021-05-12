package com.pp.rest.posts.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pp.rest.posts.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	

}
