package com.htakemoto.domain;

import lombok.Data;

@Data
public class Item {
    
    private String itemName;
    private Integer quantity;

    // The default constructor only exists for the sake of JPA.
    // You won’t use it directly, so it is designated as protected.
    protected Item() {}
}
