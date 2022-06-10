package com.thereisnouserwebsite.api.product.repository;

import com.thereisnouserwebsite.product.client.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
