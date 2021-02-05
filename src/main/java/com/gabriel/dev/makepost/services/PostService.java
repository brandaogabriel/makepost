package com.gabriel.dev.makepost.services;

import com.gabriel.dev.makepost.dtos.PostDTO;
import com.gabriel.dev.makepost.entities.Post;
import com.gabriel.dev.makepost.repositories.PostRepository;
import com.gabriel.dev.makepost.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;


	public PostDTO findById(String id) {
		Post post = getPostByIdOnDB(id);
		return new PostDTO(post);
	}

	private Post getPostByIdOnDB(String id) {
		Optional<Post> obj = this.repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Post not found"));
	}

}
