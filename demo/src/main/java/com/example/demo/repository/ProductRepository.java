package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //use this for search option
    List<Product> findByProductNameContaining(String name);

    Product findByProductName(String productName);


    List<Product> findByCategory(String id);

    Product findByProductId(Long id);
}
