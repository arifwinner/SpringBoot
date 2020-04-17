package com.areef.springBootExample.springboot_demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.areef.springBootExample.springboot_demo.post.Posts;

@Component
public class UserDAOService {

	private static List<User> users = new ArrayList<User>();
	private static List<Posts> posts1 = new ArrayList<>();
	private static List<Posts> posts2 = new ArrayList<>();

	private int counter = 3;

	static {
		posts1.add(new Posts(1, "User 1 Post 1 message"));
		posts1.add(new Posts(2, "User 1 Post 2 message"));
		posts1.add(new Posts(3, "User 1 Post 3 message"));
		posts1.add(new Posts(4, "User 1 Post 4 message"));

		posts2.add(new Posts(1, "User 2 Post 1 message"));
		posts2.add(new Posts(2, "User 2 Post 2 message"));
		posts2.add(new Posts(3, "User 2 Post 3 message"));
		posts2.add(new Posts(4, "User 2 Post 4 message"));

		users.add(new User(1, "Arif", new Date(), posts1));
		users.add(new User(2, "Saarah", new Date(), posts2));
		users.add(new User(3, "Arish", new Date(), null));
	}

	public User addUser(User user) {
		if (user.getId() == null) {
			user.setId(++counter);
		}
		users.add(user);
		return user;
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public List<Posts> findAllPosts(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user.getPosts();
			}
		}
		return null;
	}

	public void deleteUser(int id) {

		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId().equals(id)) {
				iterator.remove();
			}

		}
	}
}
