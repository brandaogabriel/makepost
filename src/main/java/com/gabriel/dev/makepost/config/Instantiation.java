package com.gabriel.dev.makepost.config;

import com.gabriel.dev.makepost.entities.User;
import com.gabriel.dev.makepost.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class Instantiation {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void createSeed() {
		this.userRepository.deleteAll();

		User maria = new User("Maria Brown", "maria@gmail.com");
		User alex = new User("Alex Green", "alex@gmail.com");
		User bob = new User("Bob Grey", "bob@gmail.com");

		this.userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}
}
