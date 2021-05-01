package com.pp.rest.users.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.pp.rest.users.vos.User;

@Component
public class UsersDao {
	AtomicInteger i=new AtomicInteger(4);
	private List<User> users=new ArrayList<>();
	{
		users.add(new User(1,"jack",new Date()));
		users.add(new User(2,"brad",new Date()));
		users.add(new User(3,"leo",new Date()));
		users.add(new User(4,"mat",new Date()));
		
	}
	
	
	public User getUser(int id) {
		for(User u: users) {
			if(u.getId()==id) {
				return u;
			}
		}
		return null;
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User saveUser(User u) {
		if(u.getId()==0) {
			u.setId(i.incrementAndGet());
		}
		users.add(u);
		return u;
	}
}
