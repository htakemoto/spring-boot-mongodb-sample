package com.htakemoto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

@Configuration
public class Beans {
    
    @Bean 
    public MongoFactoryBean mongo() {
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.setHost("localhost");
        return mongo;
    }
    
    @Bean 
    public MongoTemplate mongoTemplate(Mongo mongo) {
        MongoTemplate mongoTemplate = new MongoTemplate(mongo, "sample");
        return mongoTemplate;
    }
}
