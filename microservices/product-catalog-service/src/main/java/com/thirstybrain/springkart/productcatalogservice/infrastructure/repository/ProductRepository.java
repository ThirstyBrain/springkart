package com.thirstybrain.springkart.productcatalogservice.infrastructure.repository;


import com.thirstybrain.springkart.productcatalogservice.infrastructure.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductid(int productid);

    void deleteByProductid(int productid);
}
