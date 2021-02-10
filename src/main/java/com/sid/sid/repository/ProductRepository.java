package com.sid.sid.repository;

import com.sid.sid.entities.Category;
import com.sid.sid.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
