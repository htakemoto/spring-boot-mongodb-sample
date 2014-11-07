package com.htakemoto.rest.domain;

import java.util.List;

import com.htakemoto.domain.Item;

import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String firstname;
    private String lastname;

    private List<Item> items;
}
