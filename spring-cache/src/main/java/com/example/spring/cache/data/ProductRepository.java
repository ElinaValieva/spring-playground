package com.example.spring.cache.data;

import com.example.spring.cache.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String> {

    Optional<Product> findByType(String type);
}
