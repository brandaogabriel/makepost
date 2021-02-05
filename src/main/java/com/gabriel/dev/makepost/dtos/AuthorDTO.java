package com.gabriel.dev.makepost.dtos;

import com.gabriel.dev.makepost.entities.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public AuthorDTO() {
	}

	public AuthorDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
