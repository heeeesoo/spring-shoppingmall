package com.example.shoppingmall.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductJPARepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(int id);
}
