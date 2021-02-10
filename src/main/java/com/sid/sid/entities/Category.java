package com.sid.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Category {

    @Id
    private String id;
    private String nameCategory;

    @DBRef
    private Collection<Product> products;
}
