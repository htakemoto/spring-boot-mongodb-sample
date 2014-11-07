package com.htakemoto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.htakemoto.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    // No need to put query annotation if method name follows naming rule.
    // For details, check Spring Data MongoDB documentation
//    List<User> findByLastname(String lastname);
}
