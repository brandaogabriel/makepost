package com.gabriel.dev.makepost.resources;

import com.gabriel.dev.makepost.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User gabriel = new User("1001", "Gabriel", "gabriel@email.com");
		User carol = new User("1002", "Carol", "carol@email.com");
		List<User> users = new ArrayList<>(Arrays.asList(gabriel, carol));
		return ResponseEntity.ok().body(users);
	}
}
