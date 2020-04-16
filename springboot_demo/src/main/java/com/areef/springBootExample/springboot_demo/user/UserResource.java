package com.areef.springBootExample.springboot_demo.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User savedUser = userDAOService.addUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
