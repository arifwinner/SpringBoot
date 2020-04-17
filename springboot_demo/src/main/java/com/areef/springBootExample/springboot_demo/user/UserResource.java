package com.areef.springBootExample.springboot_demo.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.hateoas.*;

import com.areef.springBootExample.springboot_demo.post.Posts;

@RestController
public class UserResource {

	@Autowired
	private UserDAOService userDAOService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userDAOService.findAll();
	}

	@GetMapping("/users/{id}")
	public User findUser(@PathVariable int id) {
		User user = userDAOService.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User savedUser = userDAOService.addUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	
	@GetMapping("/users/{id}/posts")
	public List<Posts> findPosts(@PathVariable int id) {
		List<Posts> posts = userDAOService.findAllPosts(id);
		if (posts == null)
			throw new UserNotFoundException("Noithing to show");
		return posts;
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userDAOService.deleteUser(id);
	}
	
	
}
