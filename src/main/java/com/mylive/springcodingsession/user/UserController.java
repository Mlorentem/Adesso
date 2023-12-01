package com.mylive.springcodingsession.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/testAPI/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> retrieveAllUsers() {
		return userService.retrieveAllUsers();
	}
	
	@GetMapping(value = "/testAPI/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<User> retrieveUser(@PathVariable("id") int id) {
		return userService.retrieveUser(id);
	}

	@PostMapping("/testAPI/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}
