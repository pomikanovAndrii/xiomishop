package com.example.XiaomiShop.service;

import com.example.XiaomiShop.entity.Product;
import com.example.XiaomiShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void remove(Long id) {
        productRepository.deleteById(id);
    }

}
