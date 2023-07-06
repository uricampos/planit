package com.app.server.services;

import com.app.server.entities.Product;
import com.app.server.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public List<Product> findByOrganizationId(Long id) {
        return productRepository.findByOrganizationId(id);
    }
}
