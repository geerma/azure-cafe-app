package com.cafe.server.product;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/productid/{productid}")
    public Optional<Product> getProductById(@PathVariable("productid") Long productId) {
        return productRepository.findById(productId);
    }

}