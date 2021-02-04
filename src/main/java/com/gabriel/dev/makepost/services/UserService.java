package com.gabriel.dev.makepost.services;

import com.gabriel.dev.makepost.dtos.UserDTO;
import com.gabriel.dev.makepost.entities.User;
import com.gabriel.dev.makepost.repositories.UserRepository;
import com.gabriel.dev.makepost.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserDTO> findAll() {
		List<User> users = repository.findAll();
		return users.stream().map(UserDTO::new).collect(Collectors.toList());
	}

	public UserDTO findById(String id) {
		Optional<User> obj = this.repository.findById(id);
		User user = obj.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		return new UserDTO(user);
	}

	public UserDTO insert(UserDTO userDTO) {
		User user = new User(userDTO.getEmail(), userDTO.getEmail());
		user = this.repository.save(user);
		return new UserDTO(user);
	}

	public void delete(String id) {
		findById(id);
		this.repository.deleteById(id);
	}
}
