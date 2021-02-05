package com.gabriel.dev.makepost.config;

import com.gabriel.dev.makepost.entities.Post;
import com.gabriel.dev.makepost.entities.User;
import com.gabriel.dev.makepost.repositories.PostRepository;
import com.gabriel.dev.makepost.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Instantiation {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@PostConstruct
	public void createSeed() {
		this.userRepository.deleteAll();
		this.postRepository.deleteAll();

		User maria = new User("Maria Brown", "maria@gmail.com");
		User alex = new User("Alex Green", "alex@gmail.com");
		User bob = new User("Bob Grey", "bob@gmail.com");

		Post post1 = new Post(Instant.now(), "Partiu viagem", "Vou viajar para SP, abraços!", maria);
		Post post2 = new Post(Instant.now(), "Bom dia", "Acordei feliz hoje", maria);

		this.userRepository.saveAll(Arrays.asList(maria, alex, bob));
		this.postRepository.saveAll(Arrays.asList(post1, post2));
	}
}
