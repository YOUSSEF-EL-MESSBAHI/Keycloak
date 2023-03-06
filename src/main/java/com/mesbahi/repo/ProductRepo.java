package com.mesbahi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mesbahi.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	
}
