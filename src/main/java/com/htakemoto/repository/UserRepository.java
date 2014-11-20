package com.htakemoto.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.htakemoto.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    // No need to put query annotation if method name follows naming rule.
    // For details, check Spring Data MongoDB documentation
	@Query(value="{ 'firstname' : ?0 }")
    List<User> findByFirstname(String firstname);
	
	@Query(value="{ 'firstname' : { $regex : '^?0.*', $options: 'i' } }", count = true) // i = case insensitive
    List<User> findByFirstnameStartingWith(String firstname, Sort sort);
	
	@Query(value="{ 'firstname' : ?0 }", count = true)
    List<User> countByFirstname(String firstname);
}
