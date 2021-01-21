package com.thirstybrain.springkart.productcatalogservice.domain.interfaces.repository;

import com.thirstybrain.springkart.productcatalogservice.domain.entities.ProductDomain;

import java.util.List;

public interface ProductPort {
    void addProduct(ProductDomain productDomain);
    int updateProduct(ProductDomain productDomain);
    void removeProduct(ProductDomain productDomain);
    List<ProductDomain> getProducts();
    ProductDomain getProductById(Integer productId);
}
