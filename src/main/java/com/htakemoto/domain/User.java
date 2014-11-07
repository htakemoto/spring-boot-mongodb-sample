package com.htakemoto.domain;

import java.util.List;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {

	@Id
    private String userId;
    
    private String firstname;
    private String lastname;
    private List<Item> items;

    // The default constructor only exists for the sake of JPA.
    // You won’t use it directly, so it is designated as protected.
    protected User() {}
}
