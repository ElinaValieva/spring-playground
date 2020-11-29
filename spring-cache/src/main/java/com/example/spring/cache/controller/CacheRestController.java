package com.example.spring.cache.controller;

import com.example.spring.cache.model.Product;
import com.example.spring.cache.service.ProductCacheService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CacheRestController {

    private final ProductCacheService productCacheService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productCacheService.getProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable("id") String id) {
        return ResponseEntity.ok(productCacheService.getProductById(id));
    }

    @GetMapping("/products/{type}")
    public ResponseEntity<Product> getProductsByType(@PathVariable("type") String type) {
        return ResponseEntity.ok(productCacheService.getProductByType(type));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productCacheService.createProduct(product));
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productCacheService.updateProduct(product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<HttpStatus> deleteProductById(@PathVariable("id") String id) {
        productCacheService.deleteProductById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
