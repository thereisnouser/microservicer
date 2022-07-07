package com.thereisnouserwebsite.api.product.repository;

import com.thereisnouserwebsite.product.client.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p " +
           "FROM Product AS p " +
           "INNER JOIN p.categories AS pc " +
           "WHERE pc.id = ?1")
    List<Product> findAllByCategoryId(Long id);
}
