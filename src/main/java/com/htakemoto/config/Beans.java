package com.htakemoto.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class Beans {
	
    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
    	Mongo mongo = new MongoClient("127.0.0.1", 27017);
    	UserCredentials userCredentials = new UserCredentials("", ""); // username and password
        return new SimpleMongoDbFactory(mongo, "sample", userCredentials);
    }
    
    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
