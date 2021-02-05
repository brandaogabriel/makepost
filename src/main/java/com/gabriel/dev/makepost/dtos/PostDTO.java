package com.gabriel.dev.makepost.dtos;

import com.gabriel.dev.makepost.entities.Post;

import java.io.Serializable;
import java.time.Instant;

public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private Instant date;
	private String title;
	private String body;
	private AuthorDTO author;

	public PostDTO() {
	}

	public PostDTO(Post entity) {
		this.id = entity.getId();
		this.date = entity.getDate();
		this.title = entity.getTitle();
		this.body = entity.getBody();
		this.author = entity.getAuthor();
	}

	public String getId() {
		return id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
