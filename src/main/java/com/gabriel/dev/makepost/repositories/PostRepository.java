package com.gabriel.dev.makepost.repositories;

import com.gabriel.dev.makepost.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
