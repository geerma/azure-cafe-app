package com.cafe.server.product;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductByProductId(@NonNull Long productId) throws Exception {
        Optional<Product> productOptional = productRepository.findById(productId);

        // Check if product is present in the optional
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return product;
        } else {
            throw new Exception("Product with ID " + productId + " not found");
        }
    }

    public Double getPriceByProductId(@NonNull Long productId) throws Exception {
        Optional<Product> productOptional = productRepository.findById(productId);

        // Check if product is present in the optional
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return product.getProductCost();
        } else {
            throw new Exception("Product with ID " + productId + " not found");
        }
    }

}