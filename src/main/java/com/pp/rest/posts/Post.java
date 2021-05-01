package com.pp.rest.posts;

public class Post {
	private Integer id;
	private String post;
	private Integer userid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Post(Integer id, String post, Integer userid) {
		super();
		this.id = id;
		this.post = post;
		this.userid = userid;
	}
	
	
}
