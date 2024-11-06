package com.example.XiaomiShop.repository;

import com.example.XiaomiShop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
