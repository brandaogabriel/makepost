package com.gabriel.dev.makepost.resources;

import com.gabriel.dev.makepost.dtos.PostDTO;
import com.gabriel.dev.makepost.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;


	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {
		PostDTO postDTO = this.service.findById(id);
		return ResponseEntity.ok().body(postDTO);
	}
}
