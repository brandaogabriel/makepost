package com.gabriel.dev.makepost.services;

import com.gabriel.dev.makepost.dtos.UserDTO;
import com.gabriel.dev.makepost.entities.User;
import com.gabriel.dev.makepost.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserDTO> findAll() {
		List<User> users = repository.findAll();
		return users.stream().map(UserDTO::new).collect(Collectors.toList());
	}

}
