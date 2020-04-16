package com.areef.springBootExample.springboot_demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	
	private static List<User> users = new ArrayList<User>();
	
	private int counter = 3;
	
	static {
		users.add(new User(1,"Arif", new Date()));
		users.add(new User(2,"Saarah", new Date()));
		users.add(new User(3,"Arish", new Date()));
	}

	public User addUser(User user) {
		if(user.getId() == null) {
			user.setId(++counter);
		}
		users.add(user);
		return user;
	}
	
	public  List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		for(User user: users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
}
