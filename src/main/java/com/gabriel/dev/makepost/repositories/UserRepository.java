package com.gabriel.dev.makepost.repositories;

import com.gabriel.dev.makepost.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
