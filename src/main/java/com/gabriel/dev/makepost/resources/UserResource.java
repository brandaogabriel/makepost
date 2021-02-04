package com.gabriel.dev.makepost.resources;

import com.gabriel.dev.makepost.dtos.UserDTO;
import com.gabriel.dev.makepost.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> usersDto = service.findAll();
		return ResponseEntity.ok().body(usersDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		UserDTO userDTO = this.service.findById(id);
		return ResponseEntity.ok().body(userDTO);
	}

	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDTO) {
		userDTO = this.service.insert(userDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(userDTO);
	}
}
