package com.htakemoto.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htakemoto.domain.User;
import com.htakemoto.repository.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    /*
     *  User Controller
     */
    
    // POST: http://localhost:8080/users
    // Content-Type: application/json
    // Payload: { "firstname": "Steve", "lastname": "Jobs" }
    @RequestMapping(value="", method=RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }
    
    // GET: http://localhost:8080/users
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<User> getUsers() {
        return userService.findAll();
    }

    // GET: http://localhost:8080/users/545c38330364a69fceefbaf4
    @RequestMapping(value="/{userId}", method=RequestMethod.GET)
    public User getUser(@PathVariable String userId) {
        return userService.findOne(userId);
    }
    
    // GET: http://localhost:8080/users/search?firstname=bo
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public List<User> findUsers(@RequestParam String firstname) {
    	Assert.isTrue(!firstname.isEmpty(), "firstname parameter must be present");
        return userService.findByFirstnameStartingWith(firstname);
    }
    
    // PUT: http://localhost:8080/users/545c38330364a69fceefbaf4
    // Content-Type: application/json
    // Payload: { "firstname": "Modified", "lastname": "Name" }
    @RequestMapping(value="/{userId}", method=RequestMethod.PUT)
    public User updateUser(@PathVariable String userId, @RequestBody User user) {
        user.setUserId(userId);
        return userService.update(user);
    }
    
    // DELETE: http://localhost:8080/users/545c38330364a69fceefbaf4
    @RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable String userId) {
        userService.delete(userId);
        return userId + " is Deleted";
    }
    
}