package com.example.spring.cache.service;

import com.example.spring.cache.data.ProductRepository;
import com.example.spring.cache.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
@Service
@AllArgsConstructor
public class ProductCacheService {

    private final ProductRepository productRepository;

    @PostConstruct
    void setup() {
        initiateWithDummyProducts().forEach(productRepository::save);
    }

    private List<Product> initiateWithDummyProducts() {
        return IntStream.range(0, 1000)
                .mapToObj(i -> Product.builder()
                        .name("Product " + i)
                        .type(i % 2 == 0 ? "Product Type A" : "Product Type B")
                        .description("Description for product " + i)
                        .build())
                .collect(Collectors.toList());
    }

    @Cacheable("products")
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(products::add);
        return products;
    }

    public Product getProductById(String id) {
        log.info("Getting all products");
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @CacheEvict(value = "products", key = "#product.type", allEntries = true)
    public Product updateProduct(Product product) {
        log.info("Updating product: {}", product);
        Product foundedProduct = productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException("Product not found"));
        Optional.ofNullable(product.getName()).ifPresent(foundedProduct::setName);
        Optional.ofNullable(product.getDescription()).ifPresent(foundedProduct::setDescription);
        Optional.ofNullable(product.getType()).ifPresent(foundedProduct::setType);
        return productRepository.save(foundedProduct);
    }

    @CacheEvict(value = "products")
    public void deleteProductById(String id) {
        log.info("Deleting product: {}", id);
        productRepository.deleteById(id);
    }

    @CacheEvict(value = "products", key = "#product.type", allEntries = true)
    public Product createProduct(Product product) {
        log.info("Creating product: {}", product);
        return productRepository.save(product);
    }

    @Cacheable(value = "products", key = "#type")
    public List<Product> getProductByType(String type) {
        log.info("Getting product by type: {}", type);
        return productRepository.findByType(type);
    }

    @PreDestroy
    void tearDown() {
        productRepository.deleteAll();
    }
}
