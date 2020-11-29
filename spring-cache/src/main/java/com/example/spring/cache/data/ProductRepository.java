package com.example.spring.cache.data;

import com.example.spring.cache.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String> {

    List<Product> findByType(String type);
}
